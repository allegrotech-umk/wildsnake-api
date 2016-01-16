package tech.allegro.wildsnake.integration.api;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tech.allegro.wildsnake.integration.Assertion.ProductListAssert;
import tech.allegro.wildsnake.integration.WildSnakeIntegrationTest;
import tech.allegro.wildsnake.integration.builders.ProductDomainBuilder;
import tech.allegro.wildsnake.integration.builders.ProductDomainListFactory;
import tech.allegro.wildsnake.model.ProductDomain;
import tech.allegro.wildsnake.product.model.Product;
import tech.allegro.wildsnake.product.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductsApiTest extends WildSnakeIntegrationTest {

    private static final int NUMBER_OF_SAVED_PRODUCTS = 6;
    @Autowired
    ProductRepository realProductRepository;

    @Test
    public void should_get_empty_list_of_products() {
        givenProduct()
                .buildNumberOfProductsAndSave(0);

        List<ProductDomain> products = thenGetProductsFromApi();

        assertThat(products).isEmpty();
    }

    @Test
    public void should_get_3_products() {
        givenProduct()
                .buildNumberOfProductsAndSave(3);

        List<ProductDomain> products = thenGetProductsFromApi();

        assertThat(products).hasSize(3);
    }

    @Test
    public void should_get_one_product() {
        List<ProductDomain> givenProducts = givenProduct()
                .buildNumberOfProductsAndSave(1);

        ProductDomain product = thenGetOneProductFromApi();

        assertThat(givenProducts.get(0)).isEqualToComparingFieldByField(product);
    }

    @Test
    public void should_get_three_newest_products() {
        List<ProductDomain> givenProduct = givenProduct()
                .buildNumberOfProductsAndSave(6);

        List<ProductDomain> products = thenGetNumberOfNewestProductsFromApi(3);

        ProductListAssert.assertThat(products)
                .isSuccessful()
                .hasNumberOfItems(3)
                .newestOf(givenProduct);
    }

    @Test
    public void should_create_a_product() {
        // given
            givenProduct()
                    .buildNumberOfProductsAndSave(0);
        // when
            thenAddOneProductToApi();
        // then
            assertThat(realProductRepository.findOneByName("Snake"))
                    .isNotNull()
                    .hasFieldOrPropertyWithValue("price", BigDecimal.valueOf(10, 2));
    }

    @Test
    public void should_update_existing_product() {
        // given
            givenProduct()
                    .buildNumberOfProductsAndSave(1);
        // when
            thenUpdateProductFromApi();
        // then
            assertThat(realProductRepository.findOneByName("product_0"))
                    .isNotNull()
                    .hasFieldOrPropertyWithValue("price", BigDecimal.valueOf(10, 2));
    }

    @Test
    public void should_delete_existing_product() {
        // given
            givenProduct()
                    .buildNumberOfProductsAndSave(1);
        // when
            thenDeleteOneProductFromApi();
        // then
            assertThat(realProductRepository.findOneByName("product_0")).isNull();
    }

    @Before
    public void setup() {
        realProductRepository.deleteAll();
    }

    private ProductDomainListFactory givenProduct() {
        return new ProductDomainListFactory(realProductRepository);
    }

    private List<ProductDomain> thenGetProductsFromApi() {
        return Lists.newArrayList(template.getForEntity("http://localhost:8080/api/v1/products", ProductDomain[].class).getBody());
    }

    private ProductDomain thenGetOneProductFromApi() {
        return template.getForEntity("http://localhost:8080/api/v1/products/product_0", ProductDomain.class).getBody();
    }

    private List<ProductDomain> thenGetNumberOfNewestProductsFromApi(int number) {
        return Lists.newArrayList(template.getForEntity(String.format("http://localhost:8080/api/v1/products?order=desc&limit=%s", number), ProductDomain[].class).getBody());
    }

    private void thenDeleteOneProductFromApi() {
        template.delete("http://localhost:8080/api/v1/products/product_0");
    }

    private ProductDomain thenAddOneProductToApi() {
        ProductDomain result = template.postForEntity("http://localhost:8080/api/v1/products", new ProductDomainBuilder("Snake").withPrice(BigDecimal.valueOf(10, 2)).build(), ProductDomain.class).getBody();
        realProductRepository.save(new Product(result));

        return result;
    }

    private void thenUpdateProductFromApi() {
        template.put("http://localhost:8080/api/v1/products/product_0", new ProductDomainBuilder("product_0").withPrice(BigDecimal.valueOf(10, 2)).build());
    }

}
