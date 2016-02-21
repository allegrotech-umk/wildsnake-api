package tech.allegro.wildsnake.product.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import tech.allegro.wildsnake.productCategory.model.ProductCategory;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product {

    @Column(unique = true)
    private final String name;
    private final String imageUrl;
    private final String description;
    private final BigDecimal price;
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_category_id")
    private final ProductCategory productCategory;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Product() {
        this.productCategory = null;
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
            @JsonProperty("price") BigDecimal price,
            @JsonProperty("productCategory") ProductCategory productCategory) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.price = price;
        this.productCategory = productCategory;
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

    public ProductCategory getProductCategory() {
        return productCategory;
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
