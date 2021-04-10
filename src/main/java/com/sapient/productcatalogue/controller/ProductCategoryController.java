package com.sapient.productcatalogue.controller;

import com.sapient.productcatalogue.model.ProductCategory;
import com.sapient.productcatalogue.service.ProductCategoryService;
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
@RequestMapping("/api/productCategory")
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductCategory>> getAllPC() {
        List<ProductCategory> productCategories = Collections.EMPTY_LIST;
        Optional<List<ProductCategory>> optionalProductCategories = productCategoryService.findAll();
        if(optionalProductCategories.isPresent()){
            productCategories = optionalProductCategories.get();
        }

        return new ResponseEntity<>(productCategories, HttpStatus.OK);
    }

    @GetMapping(value = "/productCategoryById/{id:.+}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductCategory> getProductCategoryById(@PathVariable Integer id) {
        return productCategoryService.findById(id).map(productCategory -> new ResponseEntity<>(productCategory, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/productCategoryByName/{name:.+}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductCategory>> getProductCategoryByName(@PathVariable String name) {
        Optional<List<ProductCategory>> optionalProductCategoryList = productCategoryService.getAllProductCategoryByName(name.toUpperCase());
        return optionalProductCategoryList.map(productCategoryList -> new ResponseEntity<>(productCategoryList, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(optionalProductCategoryList.get(), HttpStatus.NOT_FOUND));
    }

}
