package tech.allegro.wildsnake.integration.builders;

import tech.allegro.wildsnake.model.ProductDomain;

import java.math.BigDecimal;

public class ProductDomainBuilder {

    private int numberOfInstances = 1;

    private String name;
    private String imageUrl = "http://localhost/image";
    private String description = "description";
    private BigDecimal price;

    public ProductDomainBuilder(String name) {
        this.name = name;
    }

    public ProductDomainBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ProductDomain build() {
        return new ProductDomain(name, imageUrl, description, price);
    }

}
