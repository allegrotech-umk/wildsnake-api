package tech.allegro.wildsnake.integration.Assertion;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ListAssert;
import tech.allegro.wildsnake.product.model.Product;
import tech.allegro.wildsnake.showcase.model.ShowcaseItem;

import java.util.List;
import java.util.stream.IntStream;

public class ShowCaseItemListAssert extends ListAssert<ShowcaseItem> {

    private List<ShowcaseItem> actual;

    protected ShowCaseItemListAssert(List<ShowcaseItem> actual) {
        super(actual);
        this.actual = actual;
    }

    public static ShowCaseItemListAssert assertThat(List<ShowcaseItem> actual) {
        return new ShowCaseItemListAssert(actual);
    }

    public ShowCaseItemListAssert isSuccessful() {
        assertThat(actual).isNotNull();
        return this;
    }

    public ShowCaseItemListAssert hasNumberOfItems(int number) {
        assertThat(actual).hasSize(number);
        return this;
    }

    public ShowCaseItemListAssert newestOf(List<Product> productList) {
        int numberOfProduct = productList.size();
        int numberOfItems = actual.size();
        IntStream.range(0, actual.size()).forEach(index -> {
            Assertions.assertThat(productList.get(numberOfProduct - (numberOfItems - index)).getName())
                    .isEqualTo(actual.get(numberOfItems - index - 1).getTitle());
            Assertions.assertThat(productList.get(numberOfProduct - (numberOfItems - index)).getImageUrl())
                    .isEqualTo(actual.get(numberOfItems - index - 1).getImageUrl());
            Assertions.assertThat(productList.get(numberOfProduct - (numberOfItems - index)).getPrice())
                    .isEqualTo(actual.get(numberOfItems - index - 1).getPrice());
        });
        return this;
    }


}
