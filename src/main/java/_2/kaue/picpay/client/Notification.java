package _2.kaue.picpay.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import _2.kaue.picpay.model.Transaction;

@FeignClient(name = "Notification",url = "${client.notification-service.url}")
public interface Notification {
    
    @PostMapping
    ResponseEntity<Void> sendNotification(@RequestBody Transaction transaction);
}
