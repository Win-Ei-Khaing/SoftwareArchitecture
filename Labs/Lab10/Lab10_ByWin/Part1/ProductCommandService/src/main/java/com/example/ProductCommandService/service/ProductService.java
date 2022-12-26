package com.example.ProductCommandService.service;

import com.example.ProductCommandService.domain.Product;
import com.example.ProductCommandService.integration.JMSSender;
import com.example.ProductCommandService.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private JMSSender jmsSender;
    @Override
    public void add(Product product) {
        productRepository.save(product);
        jmsSender.sendMessage(new ProductChangeEventDTO("add", product));
    }

    @Override
    public void delete(String productId) {
        productRepository.deleteById(productId);
        jmsSender.sendMessage(new ProductChangeEventDTO("delete", new Product(productId,"",0.0)));
    }

    @Override
    public void update(String productNumber, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(productNumber);
        if(optionalProduct.isPresent()){
            productRepository.save(product);
            jmsSender.sendMessage(new ProductChangeEventDTO("update", product));
        }
    }
}
