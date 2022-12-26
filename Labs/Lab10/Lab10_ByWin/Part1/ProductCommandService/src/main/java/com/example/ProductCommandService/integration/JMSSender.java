package com.example.ProductCommandService.integration;


import com.example.ProductCommandService.service.ProductChangeEventDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JMSSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(ProductChangeEventDTO productChangeEventDTO)  {
        try {
            //convert person to JSON string
            ObjectMapper objectMapper = new ObjectMapper();
            String productChangeEventDTOString = objectMapper.writeValueAsString(productChangeEventDTO);
            System.out.println("Sending a JMS message:" + productChangeEventDTOString);
            jmsTemplate.convertAndSend("productChangeQueue", productChangeEventDTOString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}