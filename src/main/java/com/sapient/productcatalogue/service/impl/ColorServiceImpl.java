package com.sapient.productcatalogue.service.impl;

import com.sapient.productcatalogue.model.Color;
import com.sapient.productcatalogue.repository.ColorRepository;
import com.sapient.productcatalogue.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    ColorRepository colorRepository;

    @Override
    public Optional<List<Color>> findAll() {
        return Optional.ofNullable(colorRepository.findAll());
    }

    @Override
    public Optional<Color> getColorById(Integer id) {
        return Optional.ofNullable(colorRepository.getColorById(id));
    }

    @Override
    public Optional<List<Color>> getAllColorByCode(String code) {
        return Optional.ofNullable(colorRepository.getAllColorByCode(code));
    }
}
