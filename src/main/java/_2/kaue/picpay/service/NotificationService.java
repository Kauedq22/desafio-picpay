package _2.kaue.picpay.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _2.kaue.picpay.client.Notification;
import _2.kaue.picpay.model.Transaction;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NotificationService {

    private static Logger logger = LoggerFactory.getLogger(NotificationService.class);
    
    @Autowired
    private Notification notification;

    public void sendNotification(Transaction transaction){

        try {
            logger.info("Sending notification...");
            var resp = notification.sendNotification(transaction);
            if(resp.getStatusCode().isError()){
                logger.error("Error while sending notification");
            }
        } catch (Exception e) {
            logger.error("Error while sending notification", e);
        }

    }
}
