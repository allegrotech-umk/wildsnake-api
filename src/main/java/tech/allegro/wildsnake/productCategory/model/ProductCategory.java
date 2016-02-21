package tech.allegro.wildsnake.productCategory.model;

import tech.allegro.wildsnake.product.model.Product;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productCategory", targetEntity = Product
            .class)
    private Set<Product> products;

    public ProductCategory() {
        name = null;
        products = null;
    }

    public ProductCategory(String name) {
        this.products = new HashSet<>();
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Set<Product> getProducts() {
        return products;
    }

}
