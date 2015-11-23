package tech.allegro.wildsnake.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tech.allegro.wildsnake.integration.Assertion.ShowCaseItemResultAssert;
import tech.allegro.wildsnake.integration.builders.ProductListBuilder;
import tech.allegro.wildsnake.product.repository.ProductRepository;
import tech.allegro.wildsnake.showcase.model.ShowcaseItem;
import tech.allegro.wildsnake.showcase.service.ShowcaseService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class WildsnakeApplicationTests extends WildSnakeIntegrationTest {

    private static final int NUMBER_OF_SAVED_PRODUCTS = 6;

    @Autowired
    ShowcaseService showcaseService;

    @Autowired
    ProductRepository realProductRepository;

    private List<ShowcaseItem> result;

    @Test
    public void should_show_main_page() {
        // when
        ResponseEntity<String> entity = template.getForEntity("http://localhost:8080/", String.class);

        // then
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).contains("Under construction");
//        assertThat(entity.getBody()).contains("price");
    }

    //BDD way
    @Test
    public void shouldRetrieveLast3ProductsFromRepository() {
        givenProduct()
                .times(NUMBER_OF_SAVED_PRODUCTS)
                .buildAndSave();

        whenRetrivalFromRepositoryOccurs();

        thenResult()
                .isSuccessful()
                .hasNumberOfItems(3)
                .newest();
    }

    private ProductListBuilder givenProduct() {
        return new ProductListBuilder(realProductRepository);
    }

    private void whenRetrivalFromRepositoryOccurs() {
        this.result = showcaseService.getItems();
    }

    private ShowCaseItemResultAssert thenResult() {
        return new ShowCaseItemResultAssert(result, NUMBER_OF_SAVED_PRODUCTS);
    }
}
