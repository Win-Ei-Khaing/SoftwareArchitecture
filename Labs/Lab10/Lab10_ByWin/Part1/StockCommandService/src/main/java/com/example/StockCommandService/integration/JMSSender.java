package com.example.StockCommandService.integration;

import com.example.StockCommandService.service.StockChangeEventDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JMSSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(StockChangeEventDTO stockChangeEventDTO)  {
        try {
            //convert person to JSON string
            ObjectMapper objectMapper = new ObjectMapper();
            String stockChangeEventDTOString = objectMapper.writeValueAsString(stockChangeEventDTO);
            System.out.println("Sending a JMS message:" + stockChangeEventDTOString);
            jmsTemplate.convertAndSend("stockchangeQueue", stockChangeEventDTOString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
