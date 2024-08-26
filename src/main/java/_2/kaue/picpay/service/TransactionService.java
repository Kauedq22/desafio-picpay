package _2.kaue.picpay.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import _2.kaue.picpay.controllers.DTO.TransactionDTO;
import _2.kaue.picpay.exception.InsuficientBalanceException;
import _2.kaue.picpay.exception.SameIdTypeExcpetion;
import _2.kaue.picpay.exception.TransactionNotAllowedForWalletTypeException;
import _2.kaue.picpay.exception.TransactionNotAuthorized;
import _2.kaue.picpay.exception.WalletNotFoundException;
import _2.kaue.picpay.model.Transaction;
import _2.kaue.picpay.model.Wallet;
import _2.kaue.picpay.repository.TransactionRepository;
import _2.kaue.picpay.repository.WalletRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionService {

    @Autowired
    private NotificationService notification;

    @Autowired
    private AuthorizationService authorization;

    @Autowired
    private TransactionRepository transactionRepository;


    @Autowired
    private WalletRepository walletRepository;

    @Transactional
    public Transaction transfer(TransactionDTO dto){

       
        var sender = walletRepository.findById(dto.payer())
                .orElseThrow(() -> new WalletNotFoundException(dto.payer()));

        var receiver = walletRepository.findById(dto.payee())
                .orElseThrow(() -> new WalletNotFoundException(dto.payee()));
        
        sender.pay(dto.value());
        receiver.receive(dto.value());

        validate(dto, sender, receiver);

        var transfer = new Transaction(sender, receiver, dto.value());
        
        walletRepository.save(sender);
        walletRepository.save(receiver);
        var tranferResult = transactionRepository.save(transfer);

        CompletableFuture.runAsync(() -> notification.sendNotification(tranferResult));

        return tranferResult;

    }

    public void validate(TransactionDTO dto, Wallet sender, Wallet reciver){
        
        if(!sender.isBalancerEqualOrGreatherThan(dto.value())){
            throw new InsuficientBalanceException();
        }
        if(!sender.isTransferAllowedForWalletType()){
            throw new TransactionNotAllowedForWalletTypeException();
        }
        if (sender.isSameWalletType(reciver)) {  
            throw new SameIdTypeExcpetion();  
        }
        if(!authorization.isAuthorized(dto)){
            throw new TransactionNotAuthorized();
        }
    }
}
