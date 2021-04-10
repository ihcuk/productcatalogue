package com.sapient.productcatalogue.controller;

import com.sapient.productcatalogue.model.Product;
import com.sapient.productcatalogue.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = Collections.EMPTY_LIST;
        Optional<List<Product>> optionalProducts = productService.findAll();
        if(optionalProducts.isPresent()){
            products = optionalProducts.get();
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/filter/{filter}/{value}")
    public ResponseEntity<List<Product>> getProducts(@PathVariable String filter, @PathVariable String value) {
        Optional<List<Product>> optionalProducts = productService.getProducts(filter, value);
        return optionalProducts.map(products -> new ResponseEntity<>(products, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



}
