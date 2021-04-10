package com.sapient.productcatalogue.service;

import com.sapient.productcatalogue.model.Color;

import java.util.List;
import java.util.Optional;

public interface ColorService {

    Optional<List<Color>> findAll();
    Optional<Color> getColorById(Integer id);
    Optional<List<Color>> getAllColorByCode(String code);
}
