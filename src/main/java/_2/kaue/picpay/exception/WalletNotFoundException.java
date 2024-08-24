package _2.kaue.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WalletNotFoundException extends PicPayException {
    
    private Long id;

    @Override
    public ProblemDetail problemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Wallet not found");
        pb.setDetail("There is no wallet with id" + id);

        return pb;
    }
    

}
