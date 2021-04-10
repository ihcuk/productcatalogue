package com.sapient.productcatalogue.factory;

import com.sapient.productcatalogue.repository.BrandRepository;
import com.sapient.productcatalogue.repository.ColorRepository;
import com.sapient.productcatalogue.repository.ProductCategoryRepository;
import com.sapient.productcatalogue.repository.ProductRepository;
import com.sapient.productcatalogue.util.GroupBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class RepositoryFactory {

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    ColorRepository colorRepository;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    ProductRepository productRepository;

    JpaRepository getRepository(String type) {
        GroupBy groupBy = GroupBy.valueOf(type.toUpperCase());
        JpaRepository jpaRepository ;
        switch (groupBy) {
            case BRAND:
                jpaRepository = brandRepository;
                break;
            case COLOR:
                jpaRepository = colorRepository;
                break;
            case CATEGORY:
                jpaRepository = productCategoryRepository;
                break;
            default:
                jpaRepository = productRepository;
        }
        return jpaRepository;
    }
}
