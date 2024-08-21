package _2.kaue.picpay.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import _2.kaue.picpay.controllers.DTO.WalletDTO;
import _2.kaue.picpay.model.Wallet;
import _2.kaue.picpay.service.WalletService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/wallets")
@AllArgsConstructor
public class WalletController {
    
    @Autowired
    private WalletService service;

    @PostMapping
    public ResponseEntity<Wallet> creatWallet(@RequestBody @Valid WalletDTO dto) throws Exception {
        
        var wallet = service.creatWallet(dto);

        return ResponseEntity.ok(wallet);
    }

    @GetMapping
    public ResponseEntity<List<Wallet>> getAllWallets() {
       List<Wallet> wallets = this.service.getAllWallets();
       return new ResponseEntity<>(wallets, HttpStatus.OK);
    }
    
    
}
