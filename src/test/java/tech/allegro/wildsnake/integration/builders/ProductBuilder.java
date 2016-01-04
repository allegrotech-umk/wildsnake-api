package tech.allegro.wildsnake.integration.builders;

import tech.allegro.wildsnake.product.model.Product;

import java.math.BigDecimal;

public class ProductBuilder {
    private int numberOfInstances = 1;

    private String name;
    private String imageUrl = "http://localhost/image";
    private String description = "description";
    private BigDecimal price;


    public ProductBuilder(String name) {
        this.name = name;
    }

    public ProductBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Product build() {
        return new Product(name, imageUrl, description, price);
    }

}
