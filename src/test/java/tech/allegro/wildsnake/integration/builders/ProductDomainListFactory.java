package tech.allegro.wildsnake.integration.builders;

import tech.allegro.wildsnake.model.ProductDomain;
import tech.allegro.wildsnake.product.model.Product;
import tech.allegro.wildsnake.product.repository.ProductRepository;
import tech.allegro.wildsnake.productCategory.model.ProductCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ProductDomainListFactory {
    private final ProductRepository repository;

    public ProductDomainListFactory(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductDomain> buildNumberOfProductsAndSave(int numberOfProducts, ProductCategory
            category) {
        List<ProductDomain> productList = new ArrayList<>();
        IntStream.range(0, numberOfProducts).forEachOrdered(number -> {
            Product product = new ProductBuilder(String.format("product_%s", number))
                    .withCategory(category).build();
            repository.save(product);
            productList.add(new ProductDomain(product));
        });
        return productList;
    }

}
