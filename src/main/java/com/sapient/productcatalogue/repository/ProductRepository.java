package com.sapient.productcatalogue.repository;


import com.sapient.productcatalogue.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p JOIN FETCH p.color JOIN FETCH p.brand WHERE p.color_id = :colorId")
    List<Product> findByColorId(@Param(value = "colorId") Integer colorId);

    @Query("SELECT p FROM Product p JOIN FETCH p.color JOIN FETCH p.brand WHERE p.brand_id = :brandId")
    List<Product> findByBrandId(@Param(value = "brandId") Integer brandId);

    List<Product> findBySize(String actualvalue);
}
