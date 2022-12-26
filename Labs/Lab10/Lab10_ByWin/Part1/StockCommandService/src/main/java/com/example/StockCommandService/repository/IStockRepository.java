package com.example.StockCommandService.repository;

import com.example.StockCommandService.domain.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStockRepository extends MongoRepository<Stock,String > {
}

