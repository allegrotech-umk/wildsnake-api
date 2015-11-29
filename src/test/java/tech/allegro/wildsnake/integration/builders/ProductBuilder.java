package tech.allegro.wildsnake.integration.builders;

import tech.allegro.wildsnake.product.model.Product;

public class ProductBuilder {
    private int numberOfInstances = 1;

    private String name;
    private String imageUrl = "http://localhost/image";
    private String description = "description";
    private long price = 0;


    public ProductBuilder(String name) {
        this.name = name;
    }

    public ProductBuilder witchPrice(long price){
        this.price = price;
        return this;
    }

    public Product build() {
        return new Product(name, imageUrl, description, price);
    }
}
