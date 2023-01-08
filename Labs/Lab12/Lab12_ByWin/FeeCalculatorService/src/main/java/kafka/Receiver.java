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
    FeeCalculatorService feeCalculatorService;

    @KafkaListener(topics = {"ownerTopic"})
    public void receive(@Payload OwnerRecord ownerRecord,
                        @Headers MessageHeaders headers) {
        System.out.println("received message from Fee Calculator Service="+ ownerRecord.toString());
        feeCalculatorService.handleRecord(ownerRecord);
    }

}