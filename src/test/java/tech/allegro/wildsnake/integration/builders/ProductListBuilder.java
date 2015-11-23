package tech.allegro.wildsnake.integration.builders;

import tech.allegro.wildsnake.product.repository.ProductRepository;

import java.util.stream.IntStream;

public class ProductListBuilder {
    private final ProductRepository repository;
    private int times = 1;

    public ProductListBuilder(ProductRepository repository) {
        this.repository = repository;
    }

    public void buildAndSave() {
        IntStream.range(0, times).forEachOrdered(number -> {
            repository.save(new ProductBuilder(String.format("product %s", number)).build());
        });
    }

    public ProductListBuilder times(int number) {
        this.times = number;
        return this;
    }
}
