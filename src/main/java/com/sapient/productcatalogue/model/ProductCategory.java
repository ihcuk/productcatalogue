package com.sapient.productcatalogue.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Product_Category")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public  class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    @JsonIgnore
    @JsonIgnoreProperties("productCategory")
    @OneToMany(mappedBy = "productCategory")
    private Set<Product> products;
}
