package com.example.ProductCommandService.controller;

import com.example.ProductCommandService.domain.Product;
import com.example.ProductCommandService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<?> add(@RequestBody Product product){
        productService.add(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/products/{productNumber}")
    public ResponseEntity<?> delete(@PathVariable String productNumber){
        productService.delete(productNumber);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/products/{productNumber}")
    public ResponseEntity<?> update(@PathVariable String productNumber, @RequestBody Product product){
        productService.update(productNumber,product);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
}
