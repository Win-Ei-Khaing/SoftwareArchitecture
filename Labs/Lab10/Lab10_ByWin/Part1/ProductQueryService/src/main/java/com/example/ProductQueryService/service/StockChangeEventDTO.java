package com.example.ProductQueryService.service;

public class StockChangeEventDTO {
    private String productNumber;
    private int numberInStock;

    public StockChangeEventDTO() {
    }

    public StockChangeEventDTO(String productId, int numberInStock) {
        this.productNumber = productId;
        this.numberInStock = numberInStock;
    }

    public String getProductId() {
        return productNumber;
    }

    public int getNumberInStock() {
        return numberInStock;
    }
}