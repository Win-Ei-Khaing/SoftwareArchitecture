package com.example.StockCommandService.controller;

import com.example.StockCommandService.domain.Stock;
import com.example.StockCommandService.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/stocks")
    public ResponseEntity<?> add(@RequestBody Stock stock){
        stockService.add(stock);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @DeleteMapping("/stocks/{productNumber}")
    public ResponseEntity<?> delete(@PathVariable String productNumber){
        stockService.delete(productNumber);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/stocks/{productNumber}")
    public ResponseEntity<?> update(@PathVariable String productNumber, @RequestBody Stock stock){
        stockService.update(productNumber, stock);
        return new ResponseEntity<>(stock,HttpStatus.OK);
    }
}
