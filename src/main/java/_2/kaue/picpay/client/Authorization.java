package _2.kaue.picpay.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import _2.kaue.picpay.client.dto.AuthorizationDTO;

@FeignClient(name = "Authorization", url = "${client.authorization-service.url}")
public interface Authorization {

    @GetMapping
    ResponseEntity<AuthorizationDTO> IsAuthroized();
    
}
