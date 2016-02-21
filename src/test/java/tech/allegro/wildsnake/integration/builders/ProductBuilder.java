package tech.allegro.wildsnake.integration.builders;

import tech.allegro.wildsnake.product.model.Product;
import tech.allegro.wildsnake.productCategory.model.ProductCategory;

import java.math.BigDecimal;

public class ProductBuilder {
    private int numberOfInstances = 1;

    private String name;
    private String imageUrl = "http://localhost/image";
    private String description = "description";
    private ProductCategory productCategory = null;
    private BigDecimal price;


    public ProductBuilder(String name) {
        this.name = name;

    }


    public ProductBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductBuilder withCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
        return this;
    }

    public Product build() {
        return new Product(name, imageUrl, description, price, productCategory);
    }

}
