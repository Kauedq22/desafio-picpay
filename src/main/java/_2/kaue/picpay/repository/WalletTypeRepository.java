package _2.kaue.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import _2.kaue.picpay.model.WalletType;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
    
}
