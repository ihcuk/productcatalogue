package com.sapient.productcatalogue.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public  class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private Integer quantity;
    private String size;

    @Column(name = "brand_id")
    private int brand_id;

    @Column(name = "color_id")
    private Integer color_id;

    @Column(name = "product_category_id")
    private Integer product_category_id;

    @JsonIgnore
    @JsonIgnoreProperties("products")
    @ManyToOne
    @JoinColumn(insertable = false, updatable = false, name = "brand_id")
    private Brand brand;

    @JsonIgnore
    @JsonIgnoreProperties("products")
    @ManyToOne
    @JoinColumn(insertable = false, updatable = false, name = "color_id")
    private Color color;

    @JsonIgnore
    @JsonIgnoreProperties("products")
    @ManyToOne
    @JoinColumn(insertable = false, updatable = false, name = "product_category_id")
    private ProductCategory productCategory;

}
