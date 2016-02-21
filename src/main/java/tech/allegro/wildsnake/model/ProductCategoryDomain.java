package tech.allegro.wildsnake.model;

import tech.allegro.wildsnake.product.model.Product;
import tech.allegro.wildsnake.productCategory.model.ProductCategory;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class ProductCategoryDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String name;
    private Set<ProductDomain> products;

    public ProductCategoryDomain() {
        name = null;
        products = null;
    }

    public ProductCategoryDomain(String name) {
        this.products = new HashSet<>();
        this.name = name;
    }

    public ProductCategoryDomain(ProductCategory pc) {
        this.products = pc.getProducts().stream().map(ProductDomain::new).collect(Collectors
                .toSet());
        this.name = pc.getName();
    }

    public ProductCategoryDomain(String name, Set<Product> products) {
        this.products = products.stream().map(ProductDomain::new).collect(Collectors.toSet());
        this.name = name;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<ProductDomain> getProducts() {
        return products;
    }
}
