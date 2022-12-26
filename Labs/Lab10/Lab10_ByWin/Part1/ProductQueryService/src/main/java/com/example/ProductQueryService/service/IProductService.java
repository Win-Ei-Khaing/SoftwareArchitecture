package com.example.ProductQueryService.service;


import com.example.ProductQueryService.domain.Product;

public interface IProductService {
    void add(Product productDTO);
    void delete(String productId);
    void update(String productId,Product productDTO);
    Product get(String productId);

    void handle(ProductChangeEventDTO productChangeEventDTO);
    void handle(StockChangeEventDTO stockChangeEventDTO);
}
