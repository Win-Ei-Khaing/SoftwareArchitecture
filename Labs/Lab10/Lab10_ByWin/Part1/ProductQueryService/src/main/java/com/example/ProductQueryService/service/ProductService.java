package com.example.ProductQueryService.service;

import com.example.ProductQueryService.domain.Product;
import com.example.ProductQueryService.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(String productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public void update(String productId, Product productDTO) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setNumberInStock(productDTO.getNumberInStock());
            productRepository.save(product);
        }
    }


    @Override
    public Product get(String productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            return product;
        }
        return null;
    }

    @Override
    public void handle(ProductChangeEventDTO productChangeEventDTO) {
        if (productChangeEventDTO.getChange().equals("add")){
            add(productChangeEventDTO.getProduct());
        } else if (productChangeEventDTO.getChange().equals("delete")){
            delete(productChangeEventDTO.getProduct().getProductNumber());
        }
        else if (productChangeEventDTO.getChange().equals("update")){
            int quantity=0;
            Optional<Product> optionalProduct = productRepository.findById(productChangeEventDTO.getProduct().getProductNumber());
            if(optionalProduct.isPresent()){
                Product product = optionalProduct.get();
                quantity=product.getNumberInStock();
            }

            update(productChangeEventDTO.getProduct().getProductNumber(),
                    new Product(productChangeEventDTO.getProduct().getProductNumber(),
                            productChangeEventDTO.getProduct().getName(),
                            productChangeEventDTO.getProduct().getPrice(),
                            quantity));
        }
    }

    @Override
    public void handle(StockChangeEventDTO stockChangeEventDTO) {
        Optional<Product> optionalProduct = productRepository.findById(stockChangeEventDTO.getProductId());
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setNumberInStock(stockChangeEventDTO.getNumberInStock());
            System.out.println("Updating stock: "+product.getProductNumber()+" , quantity = "+stockChangeEventDTO.getNumberInStock());
            productRepository.save(product);
        }
    }


}
