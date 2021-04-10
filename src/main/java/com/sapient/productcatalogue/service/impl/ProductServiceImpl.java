package com.sapient.productcatalogue.service.impl;

import com.sapient.productcatalogue.model.Product;
import com.sapient.productcatalogue.repository.ProductRepository;
import com.sapient.productcatalogue.service.ProductService;
import com.sapient.productcatalogue.util.GroupBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public Optional<List<Product>> findAll() {
        return Optional.ofNullable(productRepository.findAll());
    }

    @Override
    public Optional<List<Product>> getProducts(String groupbyvalue, String actualvalue) {
        GroupBy groupBy = GroupBy.valueOf(groupbyvalue.toUpperCase());
        List<Product> products = Collections.emptyList();
        switch (groupBy) {
            case BRAND:
                products =  productRepository.findByBrandId(Integer.valueOf(actualvalue));
                break;
            case COLOR:
                products = productRepository.findByColorId(Integer.valueOf(actualvalue));
                break;
            case SIZE:
                products = productRepository.findBySize(actualvalue);
                break;
            default:
                break;
        }
        return Optional.ofNullable(products);
    }

}
