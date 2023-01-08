package kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {
    @Autowired
    OwnerService ownerService;

    @KafkaListener(topics = {"overSpeedTopic"})
    public void receive(@Payload SpeedRecord speedRecord,
                        @Headers MessageHeaders headers) {
        System.out.println("received message from Owner Service="+ speedRecord.toString());
        ownerService.handleRecord(speedRecord);
    }

}