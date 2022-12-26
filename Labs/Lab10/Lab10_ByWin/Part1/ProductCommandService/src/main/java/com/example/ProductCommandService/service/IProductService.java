package com.example.ProductCommandService.service;

import com.example.ProductCommandService.domain.Product;

public interface IProductService {
    void add(Product product);
    void delete(String productNumber);
    void update(String productNumber,Product product);
}
