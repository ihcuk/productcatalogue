package com.sapient.productcatalogue.service.impl;

import com.sapient.productcatalogue.model.Color;
import com.sapient.productcatalogue.model.ProductCategory;
import com.sapient.productcatalogue.repository.ProductCategoryRepository;
import com.sapient.productcatalogue.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public Optional<List<ProductCategory>> findAll() {
        return Optional.ofNullable(productCategoryRepository.findAll());
    }

    @Override
    public Optional<ProductCategory> findById(Integer id) {
        return productCategoryRepository.findById(id);
    }

    @Override
    public Optional<List<ProductCategory>> getAllProductCategoryByName(String name) {
        return Optional.ofNullable(productCategoryRepository.findByCategoryName(name));
    }
}
