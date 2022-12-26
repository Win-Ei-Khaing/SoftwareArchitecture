package com.example.StockCommandService.service;

import com.example.StockCommandService.domain.Stock;

public interface IStockService {
    void add(Stock stock);
    void delete(String productNumber);
    void update(String productNumber, Stock stock);
}
