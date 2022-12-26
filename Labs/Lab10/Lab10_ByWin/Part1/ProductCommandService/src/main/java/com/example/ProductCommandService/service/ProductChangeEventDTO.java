package com.example.ProductCommandService.service;

import com.example.ProductCommandService.domain.Product;

public class ProductChangeEventDTO {
    private String change;
    private Product product;

    public ProductChangeEventDTO() {
    }

    public ProductChangeEventDTO(String change, Product product) {
        this.change = change;
        this.product = product;
    }

    public String getChange() {
        return change;
    }

    public Product getProduct() {
        return product;
    }
}
