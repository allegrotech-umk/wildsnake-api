package tech.allegro.wildsnake.integration.builders;

import tech.allegro.wildsnake.model.ProductCategoryDomain;
import tech.allegro.wildsnake.model.ProductDomain;

import java.util.HashSet;
import java.util.Set;

public class ProductCategoryDomainBuilder {
    private String name = "Gady";
    private Set<ProductDomain> products = new HashSet<>();

    public ProductCategoryDomainBuilder withName(String categoryName) {
        this.name = categoryName;
        return this;
    }

    public ProductCategoryDomain build() {
        return new ProductCategoryDomain(name);
    }

}
