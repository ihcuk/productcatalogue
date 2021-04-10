package com.sapient.productcatalogue.repository;

import com.sapient.productcatalogue.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

    @Query("SELECT b FROM Brand b WHERE b.id=:id")
    Brand getBrandById(Integer id);

    @Query("SELECT b FROM Brand b WHERE b.name=:name")
    List<Brand> getAllBrandByName(@Param("name") String name);
}
