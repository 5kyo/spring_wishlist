package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ArrayList<Product> getAllProducts(){
        return (ArrayList<Product>) productRepository.findAll();
    }

    public Optional<Product> getSingleProduct(Long productId){
        return productRepository.findById(productId);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
}
