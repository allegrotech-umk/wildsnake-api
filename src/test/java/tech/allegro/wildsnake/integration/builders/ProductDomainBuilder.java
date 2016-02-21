package tech.allegro.wildsnake.integration.builders;

import tech.allegro.wildsnake.model.ProductDomain;
import tech.allegro.wildsnake.productCategory.model.ProductCategory;

import java.math.BigDecimal;

public class ProductDomainBuilder {
    private int numberOfInstances = 1;

    private String name;
    private String imageUrl = "http://localhost/image";
    private String description = "description";
    private BigDecimal price;
    private ProductCategory productCategory = null;


    public ProductDomainBuilder(String name, ProductCategory productCategory) {

        this.name = name;
        this.productCategory = productCategory;
    }

    public ProductDomainBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductDomain build() {
        return new ProductDomain(name, imageUrl, description, price, productCategory.getName());
    }

}
