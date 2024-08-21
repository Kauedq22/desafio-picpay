package _2.kaue.picpay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _2.kaue.picpay.controllers.DTO.WalletDTO;
import _2.kaue.picpay.model.Wallet;
import _2.kaue.picpay.repository.WalletRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WalletService {
    
    @Autowired
    private WalletRepository repository;

    public Wallet creatWallet(WalletDTO dto) throws Exception{

        var walletDb = repository.findByCpfOrEmail(dto.cpf(), dto.email());

        if(walletDb.isPresent()){
            throw new Exception("Cpf or Email alredy exists");
        }
        return repository.save(dto.toWallet());
    }

    public List<Wallet> getAllWallets(){
        return this.repository.findAll();
    }
}
