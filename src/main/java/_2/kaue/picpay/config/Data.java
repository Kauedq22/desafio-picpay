package _2.kaue.picpay.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import _2.kaue.picpay.model.WalletType;
import _2.kaue.picpay.repository.WalletTypeRepository;


@Configuration
public class Data implements CommandLineRunner {

    
    private final WalletTypeRepository walletTypeRepository;
    
    public Data(WalletTypeRepository walletTypeRepository) {
        this.walletTypeRepository = walletTypeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(WalletType.Enum.values()).forEach(walletType -> walletTypeRepository.save(walletType.get()));
    
    }
    
}
