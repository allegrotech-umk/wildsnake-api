package tech.allegro.wildsnake.integration.builders;

import tech.allegro.wildsnake.product.model.Product;

public class ProductBuilder {
    private int numberOfInstances = 1;

    private String name;
    private String imageUrl = "http://localhost/image";
    private String description = "description";


    public ProductBuilder(String name) {
        this.name = name;
    }

    public Product build() {
        return new Product(name, imageUrl, description);
    }
}
