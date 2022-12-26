package com.example.ProductQueryService.repository;

import com.example.ProductQueryService.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends MongoRepository<Product,String > {
}
