package com.example.ProductQueryService.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class StockChangeListener {
    @Autowired
    private IProductService IProductService;

    @JmsListener(destination = "stockchangeQueue")
    public void receiveMessage(final String stockChangeEventDTOString) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            StockChangeEventDTO stockChangeEventDTO = objectMapper.readValue(stockChangeEventDTOString, StockChangeEventDTO.class);
            System.out.println("JMS receiver received message:" + stockChangeEventDTOString);
            IProductService.handle(stockChangeEventDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
