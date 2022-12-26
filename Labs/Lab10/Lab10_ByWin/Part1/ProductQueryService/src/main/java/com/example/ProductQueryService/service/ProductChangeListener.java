package com.example.ProductQueryService.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ProductChangeListener {
    @Autowired
    private IProductService IProductService;

    @JmsListener(destination = "productchangeQueue")
    public void receiveMessage(final String productChangeEventDTOString) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ProductChangeEventDTO productChangeEventDTO = objectMapper.readValue(productChangeEventDTOString, ProductChangeEventDTO.class);
            System.out.println("JMS receiver received message:" + productChangeEventDTOString);
            IProductService.handle(productChangeEventDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
