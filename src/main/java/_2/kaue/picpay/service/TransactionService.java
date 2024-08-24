package _2.kaue.picpay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _2.kaue.picpay.controllers.DTO.TransactionDTO;
import _2.kaue.picpay.exception.WalletNotFoundException;
import _2.kaue.picpay.model.Transaction;
import _2.kaue.picpay.repository.TransactionRepository;
import _2.kaue.picpay.repository.WalletRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionService {

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

        var transfer = new Transaction(sender, receiver, dto.value());
        
        walletRepository.save(sender);
        walletRepository.save(receiver);
        var tranferResult = transactionRepository.save(transfer);


        return tranferResult;

    }
}
