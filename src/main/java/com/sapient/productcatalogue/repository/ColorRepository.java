package com.sapient.productcatalogue.repository;

import com.sapient.productcatalogue.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer> {
    Color getColorById(Integer id);
    @Query("SELECT c FROM Color c WHERE c.code=:code")
    List<Color> getAllColorByCode(@Param("code") String code);
}
