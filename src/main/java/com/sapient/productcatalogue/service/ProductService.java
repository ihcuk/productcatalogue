package com.sapient.productcatalogue.service;

import com.sapient.productcatalogue.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<List<Product>> findAll();
    Optional<List<Product>> getProducts(String groupbyvalue, String actualvalue);
}
