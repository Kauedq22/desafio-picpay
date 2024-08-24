package _2.kaue.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class PicPayException extends RuntimeException {

    public ProblemDetail problemDetail(){
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pb.setTitle("PicPay internal error");
        return pb;
    }
    
}
