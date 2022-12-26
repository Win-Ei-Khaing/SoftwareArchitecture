package com.example.ProductQueryService.controller;

import com.example.ProductQueryService.domain.Product;
import com.example.ProductQueryService.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/products/{product_id}")
    public ResponseEntity<?> get(@PathVariable String product_id){
        Product product = productService.get(product_id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
