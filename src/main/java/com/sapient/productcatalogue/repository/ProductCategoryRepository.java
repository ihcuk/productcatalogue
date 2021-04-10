package com.sapient.productcatalogue.repository;

import com.sapient.productcatalogue.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    @Query("SELECT pc FROM ProductCategory pc WHERE pc.name=:name")
    List<ProductCategory> findByCategoryName(@Param("name") String name);
}
