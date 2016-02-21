package tech.allegro.wildsnake.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.allegro.wildsnake.product.model.Product;

import java.math.BigDecimal;

public class ProductDomain {

    private final String name;
    private final String imageUrl;
    private final String description;
    private final BigDecimal price;
    private final String productCategory;

    public ProductDomain(
            @JsonProperty("name") String name,
            @JsonProperty("imageUrl") String imageUrl,
            @JsonProperty("description") String description,
            @JsonProperty("price") BigDecimal price,
            @JsonProperty("productCategory") String productCategory) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
        this.productCategory = productCategory;
    }

    public ProductDomain(Product product) {
        this.name = product.getName();
        this.imageUrl = product.getImageUrl();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.productCategory = product.getProductCategory().getName();
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

    public BigDecimal getPrice() {
        return price;
    }

    public String getProductCategory() {
        return productCategory;
    }

    @Override
    public String toString() {
        return "ProductDomain{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", productCategory='" + productCategory + '\'' +
                '}';
    }
}
