package com.example.ProductCommandService.repository;

import com.example.ProductCommandService.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends MongoRepository<Product,String > {
}

