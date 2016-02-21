package tech.allegro.wildsnake.integration.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tech.allegro.wildsnake.integration.WildSnakeIntegrationTest;
import tech.allegro.wildsnake.integration.builders.ProductCategoryDomainBuilder;
import tech.allegro.wildsnake.model.ProductCategoryDomain;
import tech.allegro.wildsnake.productCategory.repository.ProductCategoryRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductCategoryApiTest extends WildSnakeIntegrationTest {


    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Test
    public void should_creaty_new_category() {
        //given

        //when
        thenCreateProductCategoryByApi();

        //then
        assertThat(productCategoryRepository.findOneByName("Koty")).isNotNull();
    }

    @Before
    public void setup() {
        productCategoryRepository.deleteAll();
    }

    private ProductCategoryDomain thenGetOneProductCategoryFromApi() {
        return template.getForEntity("http://localhost:8080/api/v1/productCategories/category0",
                ProductCategoryDomain.class).getBody();
    }

    private void thenCreateProductCategoryByApi() {
        template.put("http://localhost:8080/api/v1/productCategories", new
                ProductCategoryDomainBuilder().withName("Koty").build());
    }
}
