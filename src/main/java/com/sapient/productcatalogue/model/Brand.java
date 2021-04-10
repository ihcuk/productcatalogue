package com.sapient.productcatalogue.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Brand")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public  class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JsonIgnore
    @JsonIgnoreProperties("brand")
    @OneToMany(mappedBy = "brand")
    private Set<Product> products;

    private String name;
}
