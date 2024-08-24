package _2.kaue.picpay.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import _2.kaue.picpay.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, UUID>{
    
}
