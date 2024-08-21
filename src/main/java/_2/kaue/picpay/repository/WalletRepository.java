package _2.kaue.picpay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import _2.kaue.picpay.model.Wallet;
import jakarta.validation.constraints.NotBlank;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Optional<Wallet> findByCpfOrEmail(@NotBlank String cpf, @NotBlank String email);
    
}
