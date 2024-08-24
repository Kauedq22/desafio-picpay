package _2.kaue.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InsuficientBalanceException extends PicPayException{

    @Override
    public ProblemDetail problemDetail() {
        var pb =ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Insuficient balance");
        pb.setDetail("You cannot transfer a value bigger than you current balance");

        return pb;
    }
    
}
