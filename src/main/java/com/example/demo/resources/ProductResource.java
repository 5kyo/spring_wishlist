package com.example.demo.resources;

import java.util.ArrayList;
import java.util.Optional;

import javax.websocket.server.PathParam;

import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductResource {
    
    @Autowired
    ProductService productService;

    @GetMapping()
    public ArrayList<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping( path = "/{productId}" )
    public Optional<Product> getSingleUser(@PathParam("productId") Long productId) {
        return productService.getSingleProduct(productId);
    }
    
    @PostMapping()
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    
}
