package tech.allegro.wildsnake.integration.Assertion;

import org.assertj.core.api.ListAssert;
import tech.allegro.wildsnake.product.model.Product;

import java.util.List;

public class ProductListAssert extends ListAssert<Product> {
    private List<Product> actual;

    protected ProductListAssert(List<Product> productList) {
        super(productList);
        this.actual = productList;
    }

    public static ProductListAssert assertThat(List<Product> actual) {
        return new ProductListAssert(actual);
    }

    public ProductListAssert isSuccessful() {
        assertThat(actual).isNotNull();
        return this;
    }

    public ProductListAssert hasNumberOfItems(int number) {
        assertThat(actual).hasSize(number);
        return this;
    }

    public ProductListAssert newestOf(List<Product> productList) {
        List<Product> newestProducts = productList.subList(productList.size() - actual.size(), productList.size());
        assertThat(actual).containsExactly(newestProducts.toArray(new Product[newestProducts.size()]));
        return this;
    }
}
