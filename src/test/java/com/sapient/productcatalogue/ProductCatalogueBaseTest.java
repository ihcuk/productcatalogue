package com.sapient.productcatalogue;

import com.sapient.productcatalogue.controller.BrandController;
import com.sapient.productcatalogue.controller.ColorController;
import com.sapient.productcatalogue.controller.ProductCategoryController;
import com.sapient.productcatalogue.controller.ProductController;
import com.sapient.productcatalogue.exception.CatalogueExceptionHandler;
import com.sapient.productcatalogue.model.Brand;
import com.sapient.productcatalogue.model.Color;
import com.sapient.productcatalogue.model.Product;
import com.sapient.productcatalogue.model.ProductCategory;
import com.sapient.productcatalogue.model.api.ServiceError;
import com.sapient.productcatalogue.service.BrandService;
import com.sapient.productcatalogue.service.ColorService;
import com.sapient.productcatalogue.service.ProductCategoryService;
import com.sapient.productcatalogue.service.ProductService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.xml.ws.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductCatalogueBaseTest {
    protected MockMvc mockMvc;
    protected MockMvc mockMvcBrandController;
    protected MockMvc mockMvcColorController;
    protected MockMvc mockMvcProductCategoryController;
    protected MockMvc mockMvcProductController;

    @Mock
    BrandService brandService;

    @Mock
    ColorService colorService;

    @Mock
    ProductCategoryService productCategoryService;

    @Mock
    ProductService productService;

    @Mock
    BrandController brandController;

    @Mock
    ColorController colorController;

    @Mock
    ProductCategoryController productCategoryController;

    @Mock
    ProductController productController;

    @InjectMocks
    CatalogueExceptionHandler catalogueExceptionHandler;

    @Mock
    ServiceError serviceError;

    @Before
    public void setUp() throws Exception{
        this.mockMvcBrandController = MockMvcBuilders.standaloneSetup(brandController).build();
        this.mockMvcColorController = MockMvcBuilders.standaloneSetup(colorController).build();
        this.mockMvcProductCategoryController = MockMvcBuilders.standaloneSetup(productCategoryController).build();
        this.mockMvcProductController = MockMvcBuilders.standaloneSetup(productController).build();
        when(brandService.getBrandById(any())).thenReturn(Optional.ofNullable(getBrand()));
        when(brandService.getAllBrandByName(any())).thenReturn(Optional.ofNullable(getBrandAsList()));
        when(colorService.getColorById(any())).thenReturn(Optional.ofNullable(getColor()));
        when(colorService.getAllColorByCode(any())).thenReturn(Optional.of(Arrays.asList(getColor(), getColor(), getColor())));
        when(productCategoryService.getAllProductCategoryByName(any())).thenReturn(Optional.of(Arrays.asList(getProductCategory())));
        when(productCategoryService.findAll()).thenReturn(Optional.of(Arrays.asList(getProductCategory())));
        when(productService.findAll()).thenReturn(Optional.of(Arrays.asList(getProduct())));
        when(productService.getProducts(any(), any())).thenReturn(Optional.of(Arrays.asList(getProduct())));
    }

    public Brand getBrand() {
        Brand brand = new Brand();
        brand.setId(1);
        brand.setName("ADIDAS");
        return brand;
    }

    public List<Brand> getBrandAsList() {
        return Arrays.asList(getBrand());
    }

    public Color getColor() {
        Color color = new Color();
        color.setId(1);
        color.setName("BLUE");
        return color;
    }

    public ProductCategory getProductCategory(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(1);
        return productCategory;
    }

    public Product getProduct() {
        return new Product();
    }

}
