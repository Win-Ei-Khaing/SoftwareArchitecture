package com.example.StockCommandService.service;

public class StockChangeEventDTO {
    private String productId;
    private int numberInStock;

    public StockChangeEventDTO() {
    }

    public StockChangeEventDTO(String productId, int numberInStock) {
        this.productId = productId;
        this.numberInStock = numberInStock;
    }

    public String getProductId() {
        return productId;
    }

    public int getNumberInStock() {
        return numberInStock;
    }
}
