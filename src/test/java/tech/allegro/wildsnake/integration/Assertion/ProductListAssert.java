package tech.allegro.wildsnake.integration.Assertion;

import org.assertj.core.api.ListAssert;
import tech.allegro.wildsnake.model.ProductDomain;

import java.util.Collections;
import java.util.List;

public class ProductListAssert extends ListAssert<ProductDomain> {
    private List<ProductDomain> actual;

    protected ProductListAssert(List<ProductDomain> productList) {
        super(productList);
        this.actual = productList;
    }

    public static ProductListAssert assertThat(List<ProductDomain> actual) {
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

    public ProductListAssert newestOf(List<ProductDomain> productList) {
        List<ProductDomain> newestProducts = productList.subList(productList.size() - actual.size(), productList.size());
        Collections.reverse(newestProducts);
        assertThat(actual).usingFieldByFieldElementComparator().containsExactly(newestProducts.toArray(new ProductDomain[newestProducts.size()]));
        return this;
    }
}
