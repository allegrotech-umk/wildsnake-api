package tech.allegro.wildsnake.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.allegro.wildsnake.product.model.Product;

import java.math.BigDecimal;

public class ProductDomain {

    private String name;
    private String imageUrl;
    private String description;
    private BigDecimal price;

    public ProductDomain() {

    }

    public ProductDomain(
            @JsonProperty("name") String name,
            @JsonProperty("imageUrl") String imageUrl,
            @JsonProperty("description") String description,
            @JsonProperty("price") BigDecimal price) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
    }

    public ProductDomain(Product product) {
        this.name = product.getName();
        this.imageUrl = product.getImageUrl();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDomain{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
