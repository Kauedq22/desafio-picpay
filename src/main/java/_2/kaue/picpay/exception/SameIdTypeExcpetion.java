package _2.kaue.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class SameIdTypeExcpetion extends PicPayException{

    @Override
    public ProblemDetail problemDetail() {
      var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

      pb.setTitle("It is not allowed to send to yourself...");
      

      return pb;
    }
    
}
