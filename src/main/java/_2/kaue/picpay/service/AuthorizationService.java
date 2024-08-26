package _2.kaue.picpay.service;

import org.springframework.stereotype.Service;

import _2.kaue.picpay.client.Authorization;
import _2.kaue.picpay.controllers.DTO.TransactionDTO;
import _2.kaue.picpay.exception.PicPayException;

@Service
public class AuthorizationService {

    private final Authorization authorization;

    public AuthorizationService(Authorization authorizationClient) {
        this.authorization = authorizationClient;
    }

    public boolean isAuthorized(TransactionDTO transfer) {

        var resp = authorization.IsAuthroized();

        if (resp.getStatusCode().isError()) {
            throw new PicPayException();
        }

        return resp.getBody().authorized();
    }
}
