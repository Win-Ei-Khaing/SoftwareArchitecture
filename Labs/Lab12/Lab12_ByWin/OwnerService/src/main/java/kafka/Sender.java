package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    @Autowired
    private KafkaTemplate<String, OwnerRecord> kafkaTemplate;

    public void send(OwnerRecord ownerRecord){
        kafkaTemplate.send("ownerTopic", ownerRecord);
    }
}
