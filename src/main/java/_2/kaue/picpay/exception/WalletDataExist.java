package _2.kaue.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WalletDataExist extends PicPayException {

    private String detail;

    @Override
    public ProblemDetail problemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Wallet data alredy exist");
        pb.setDetail(detail);

        return pb;
    }
    
    
}
