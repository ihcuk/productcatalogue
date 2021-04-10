package com.sapient.productcatalogue.service;

import com.sapient.productcatalogue.model.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryService {
    Optional<List<ProductCategory>> findAll();
    Optional<ProductCategory> findById(Integer id);
    Optional<List<ProductCategory>> getAllProductCategoryByName(String name);
}
