package tech.allegro.wildsnake.product.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import tech.allegro.wildsnake.model.ProductDomain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Product {

    private final String name;
    private final String imageUrl;
    private final String description;
    private final BigDecimal price;
    @Id
    @GeneratedValue
    private long id;

    public Product() {
        this.name = null;
        this.imageUrl = null;
        this.description = null;
        this.price = null;
    }

    @JsonCreator
    public Product(
            @JsonProperty("name") String name,
            @JsonProperty("imageUrl") String imageUrl,
            @JsonProperty("description") String description,
            @JsonProperty("price") BigDecimal price) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
    }

    public Product(ProductDomain productDomain) {
        this.name = productDomain.getName();
        this.imageUrl = productDomain.getImageUrl();
        this.description = productDomain.getDescription();
        this.price = productDomain.getPrice();
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

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
