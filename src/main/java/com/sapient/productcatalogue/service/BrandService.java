package com.sapient.productcatalogue.service;

import com.sapient.productcatalogue.model.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {

    Optional<List<Brand>> findAll();
    Optional<Brand> getBrandById(Integer id);
    Optional<List<Brand>> getAllBrandByName(String name);
}
