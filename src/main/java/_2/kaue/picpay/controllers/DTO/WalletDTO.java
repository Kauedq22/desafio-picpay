package _2.kaue.picpay.controllers.DTO;

import java.math.BigDecimal;

import _2.kaue.picpay.model.Wallet;
import _2.kaue.picpay.model.WalletType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record WalletDTO(@NotBlank String fullName,
                        @NotBlank String email,
                        @NotBlank String cpf,
                        @NotBlank String password,
                        @DecimalMin("1.0") @NotNull BigDecimal balance,
                        @NotNull WalletType.Enum walletType) {
    public Wallet toWallet(){
        return new Wallet(null, fullName,
                            email,
                            cpf,
                            password,
                            balance,
                            walletType.get());
    }
}
