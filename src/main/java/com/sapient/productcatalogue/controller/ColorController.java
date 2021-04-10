package com.sapient.productcatalogue.controller;

import com.sapient.productcatalogue.model.Brand;
import com.sapient.productcatalogue.model.Color;
import com.sapient.productcatalogue.service.ColorService;
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
@RequestMapping("/api/colors")
public class ColorController {

    @Autowired
    ColorService colorService;

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Color>> getAllColors() {
        List<Color> colors = Collections.EMPTY_LIST;
        Optional<List<Color>> colorsOptional = colorService.findAll();
        if(colorsOptional.isPresent()){
            colors = colorsOptional.get();
        }

        return new ResponseEntity<>(colors, HttpStatus.OK);
    }

    @GetMapping(value = "/colorById/{id:.+}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Color> getColorById(@PathVariable Integer id) {
        return colorService.getColorById(id).map(color -> new ResponseEntity<>(color, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/colorByCode/{name:.+}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Color>> getColorByCode(@PathVariable String name) {
        Optional<List<Color>> colorsOptional = colorService.getAllColorByCode(name.toUpperCase());
        return colorsOptional.map(colors -> new ResponseEntity<>(colors, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(colorsOptional.get(), HttpStatus.NOT_FOUND));
    }
}
