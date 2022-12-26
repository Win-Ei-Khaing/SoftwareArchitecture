package com.example.StockCommandService.service;

import com.example.StockCommandService.domain.Stock;
import com.example.StockCommandService.integration.JMSSender;
import com.example.StockCommandService.repository.IStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService implements IStockService {
    @Autowired
    private IStockRepository stockRepository;
    @Autowired
    private JMSSender jmsSender;

    @Override
    public void add(Stock stock) {
        stockRepository.save(stock);
    }

    @Override
    public void delete(String productId) {
        stockRepository.deleteById(productId);
    }

    @Override
    public void update(String productNumber, Stock stock) {
        Optional<Stock> optionalProduct = stockRepository.findById(productNumber);
        if(optionalProduct.isPresent()){
            stockRepository.save(stock);
        }
    }
}
