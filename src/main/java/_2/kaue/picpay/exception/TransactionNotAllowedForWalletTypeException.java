package _2.kaue.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransactionNotAllowedForWalletTypeException extends PicPayException{

    @Override
    public ProblemDetail problemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("This type of wallet is not allowed to transfer");

        return pb;
    }
    
}
