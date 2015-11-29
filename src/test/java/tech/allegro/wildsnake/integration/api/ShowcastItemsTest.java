package tech.allegro.wildsnake.integration.api;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tech.allegro.wildsnake.integration.WildSnakeIntegrationTest;
import tech.allegro.wildsnake.integration.builders.ProductListFactory;
import tech.allegro.wildsnake.product.repository.ProductRepository;
import tech.allegro.wildsnake.showcase.model.ShowcaseItem;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class ShowcastItemsTest extends WildSnakeIntegrationTest {

    @Test
    public void should_get_empty_list_items() {
        givenProduct()
                .buildNumberOfProductsAndSave(0);

        List<ShowcaseItem> showcaseItems = thenGetShowcaseItemsFromApi();

        assertThat(showcaseItems).isEmpty();
    }

    @Autowired
    ProductRepository realProductRepository;

    private ProductListFactory givenProduct() {
        return new ProductListFactory(realProductRepository);
    }

    private List<ShowcaseItem> thenGetShowcaseItemsFromApi() {
        return Lists.newArrayList(template.getForEntity("http://localhost:8080/api/showcase/items", ShowcaseItem[].class).getBody());
    }

}
