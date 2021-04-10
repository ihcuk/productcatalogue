package com.sapient.productcatalogue.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Color")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JsonIgnore
    @JsonIgnoreProperties("color")
    @OneToMany(mappedBy = "color")
    private Set<Product> products;
    private String name;
    private String code;
}
