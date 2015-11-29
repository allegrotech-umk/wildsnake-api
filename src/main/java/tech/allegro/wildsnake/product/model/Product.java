package tech.allegro.wildsnake.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String imageUrl;
    private String description;
    private long price;

    public Product() {
    }

    public Product(String name, String imageUrl, String description, long price) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public long getPrice() {
        return price;
    }
}
