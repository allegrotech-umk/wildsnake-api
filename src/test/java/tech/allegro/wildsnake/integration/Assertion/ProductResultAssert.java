package tech.allegro.wildsnake.integration.Assertion;

import tech.allegro.wildsnake.integration.builders.ProductBuilder;
import tech.allegro.wildsnake.product.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductResultAssert {
    private int limit = 1;
    private int storedNumber;
    private List<Product> result;

    public ProductResultAssert(List<Product> actual, int numberOfSavedProducts) {
        this.result = actual;
        this.storedNumber = numberOfSavedProducts;
    }

    public ProductResultAssert isSuccessful() {
        assertThat(result).isNotNull();
        return this;
    }

    public ProductResultAssert hasNumberOfItems(int number) {
        this.limit = number;
        assertThat(result.size()).isEqualTo(number);
        return this;
    }

    public ProductResultAssert newest() {
        List<Product> expectedProducts = new ArrayList<>();
        IntStream.range(0, storedNumber).forEach(number -> {
            expectedProducts.add(new ProductBuilder(String.format("product_%s", number)).build());
        });
        IntStream.range(0, limit).forEach(index -> {
            assertThat(expectedProducts.get(storedNumber - (limit - index)).getName()).isEqualTo(result.get(limit - index - 1).getName());
            assertThat(expectedProducts.get(storedNumber - (limit - index)).getImageUrl()).isEqualTo(result.get(limit - index - 1).getImageUrl());
            assertThat(expectedProducts.get(storedNumber - (limit - index)).getPrice()).isEqualTo(result.get(limit - index - 1).getPrice());
        });
        return this;
    }
}
