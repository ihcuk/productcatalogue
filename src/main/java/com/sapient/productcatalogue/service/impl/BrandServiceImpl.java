package com.sapient.productcatalogue.service.impl;

import com.sapient.productcatalogue.model.Brand;
import com.sapient.productcatalogue.repository.BrandRepository;
import com.sapient.productcatalogue.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository brandRepository;

    @Override
    public Optional<List<Brand>> findAll() {
        Optional<List<Brand>> brands = Optional.ofNullable(brandRepository.findAll());
        return brands;
    }

    @Override
    public Optional<Brand> getBrandById(Integer id) {
        Optional<Brand> brands = Optional.ofNullable(brandRepository.getBrandById(id));
        return brands;
    }

    @Override
    public Optional<List<Brand>> getAllBrandByName(String name) {
        Optional<List<Brand>> brands = Optional.ofNullable(brandRepository.getAllBrandByName(name));
        return brands;
    }
}
