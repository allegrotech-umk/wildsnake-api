package tech.allegro.wildsnake.integration.builders;

import tech.allegro.wildsnake.model.ProductDomain;
import tech.allegro.wildsnake.product.model.Product;
import tech.allegro.wildsnake.product.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ProductDomainListFactory {
    private final ProductRepository repository;

    public ProductDomainListFactory(ProductRepository repository) {
        this.repository = repository;
    }



    public List<ProductDomain> buildNumberOfProductsAndSave(int numberOfProducts) {
        List<ProductDomain> productList = new ArrayList<>();
        IntStream.range(0, numberOfProducts).forEachOrdered(number -> {
            Product product = new ProductBuilder(String.format("product_%s", number)).withPrice(new BigDecimal("10.00")).build();
            repository.save(product);
            productList.add(new ProductDomain(product));
        });
        return productList;
    }

    public List<ProductDomain> buildNumberOfProductsWithCustomPriceAndSave(int numberOfProducts){
        List<ProductDomain> productList = new ArrayList<>();
        IntStream.range(0, numberOfProducts).forEachOrdered(number -> {

            Product product = new ProductBuilder(String.format("product_%s", number)).withPrice(new BigDecimal((number)*5).setScale(2,BigDecimal.ROUND_HALF_UP)).build();
            repository.save(product);
            productList.add(new ProductDomain(product));
        });
        return productList;
    }

}
