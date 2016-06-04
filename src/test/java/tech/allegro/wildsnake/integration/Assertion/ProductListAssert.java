package tech.allegro.wildsnake.integration.Assertion;

import org.assertj.core.api.ListAssert;
import tech.allegro.wildsnake.model.ProductDomain;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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


    public void hasPriceBetween(BigDecimal priceMin, BigDecimal priceMax, List<ProductDomain> givenProduct) {
        List<ProductDomain> correctProduct = givenProduct.stream()
                .filter(product -> product.getPrice().compareTo(priceMin) >= 0 && product.getPrice().compareTo(priceMax) <= 0)
                .collect(Collectors.toList());
        assertThat(actual).usingFieldByFieldElementComparator().containsExactly(correctProduct.toArray(new ProductDomain[correctProduct.size()]));
    }

    public void withNameContains(String name, List<ProductDomain> givenProduct) {
        List<ProductDomain> correctProduct = givenProduct.stream()
                .filter(product -> product.getName().toLowerCase().contains(name))
                .collect(Collectors.toList());
        assertThat(actual).usingFieldByFieldElementComparator().containsExactly(correctProduct.toArray(new ProductDomain[correctProduct.size()]));
    }
}
