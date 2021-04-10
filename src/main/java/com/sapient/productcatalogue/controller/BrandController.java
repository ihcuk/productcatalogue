package com.sapient.productcatalogue.controller;

import com.sapient.productcatalogue.exception.B2CException;
import com.sapient.productcatalogue.model.Brand;
import com.sapient.productcatalogue.service.BrandService;
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
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Brand>> getAllBrands() {
        Optional<List<Brand>> brandsOptional = brandService.findAll();
        if(!brandsOptional.isPresent()){
            throw new B2CException("Brands Not Available");
        }

        return new ResponseEntity<>(brandsOptional.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/brandById/{id:.+}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Brand> getBrandById(@PathVariable Integer id) {
        Optional<Brand> brandsOptional = brandService.getBrandById(id);
        if(!brandsOptional.isPresent()){
            throw new B2CException("Brands Not Available");
        }
        return new ResponseEntity<>(brandsOptional.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/brandByName/{name:.+}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Brand>> getBrandByName(@PathVariable String name) {
        Optional<List<Brand>> brandsOptional = brandService.getAllBrandByName(name.toUpperCase());
        if(!brandsOptional.isPresent()){
            throw new B2CException("Brands Not Available");
        }
        return new ResponseEntity<>(brandsOptional.get(), HttpStatus.OK);
    }
}
