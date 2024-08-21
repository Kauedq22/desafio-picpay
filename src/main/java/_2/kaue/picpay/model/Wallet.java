package _2.kaue.picpay.model;

import java.math.BigDecimal;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wallet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String cpf;
    private String password;
    private BigDecimal balance = BigDecimal.ZERO;
    @ManyToOne
    private WalletType WalletType;

    public Wallet(String fullName, String email, String cpf, String password,BigDecimal balance, WalletType walletType) {
        this.fullName = fullName;
        this.email = email;
        this.cpf = cpf;
        this.balance = balance;
        this.password = password;
        WalletType = walletType;
    }

    
    
}
