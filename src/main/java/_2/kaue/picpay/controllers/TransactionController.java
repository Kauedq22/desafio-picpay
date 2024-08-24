package _2.kaue.picpay.controllers;

import org.springframework.web.bind.annotation.RestController;

import _2.kaue.picpay.controllers.DTO.TransactionDTO;
import _2.kaue.picpay.model.Transaction;
import _2.kaue.picpay.service.TransactionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@AllArgsConstructor
public class TransactionController {

    @Autowired
    private TransactionService transferService;

    @PostMapping("/transfer")
    public ResponseEntity<Transaction> transfer(@RequestBody @Valid TransactionDTO dto){
        var resp = transferService.transfer(dto);

        return ResponseEntity.ok(resp);
    }
    
    
}

