package tech.allegro.wildsnake.integration.api;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tech.allegro.wildsnake.integration.Assertion.ProductListAssert;
import tech.allegro.wildsnake.integration.WildSnakeIntegrationTest;
import tech.allegro.wildsnake.integration.builders.ProductListFactory;
import tech.allegro.wildsnake.product.model.Product;
import tech.allegro.wildsnake.product.repository.ProductRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductsApiTest extends WildSnakeIntegrationTest {

    private static final int NUMBER_OF_SAVED_PRODUCTS = 6;
    @Autowired
    ProductRepository realProductRepository;

    @Ignore
    @Test
    public void should_get_empty_list_of_products() {
        givenProduct()
                .buildNumberOfProductsAndSave(0);

        List<Product> products = thenGetProductsFromApi();

        assertThat(products).isEmpty();
    }

    @Ignore
    @Test
    public void should_get_3_products() {
        givenProduct()
                .buildNumberOfProductsAndSave(3);

        List<Product> products = thenGetProductsFromApi();

        assertThat(products).hasSize(3);
    }

    @Ignore
    @Test
    public void should_get_one_product() {
        List<Product> givenProducts = givenProduct()
                .buildNumberOfProductsAndSave(1);

        Product product = thenGetOneProductFromApi();

        assertThat(givenProducts.get(0)).isEqualToComparingFieldByField(product);
    }

    @Ignore
    @Test
    public void should_get_three_newest_products() {
        List<Product> givenProduct = givenProduct()
                .buildNumberOfProductsAndSave(6);

        List<Product> products = thenGetNumberOfNewestProductsFromApi(3);

        ProductListAssert.assertThat(products)
                .isSuccessful()
                .hasNumberOfItems(3)
                .newestOf(givenProduct);
    }

    @Before
    public void setup() {
        realProductRepository.deleteAll();
    }

    private ProductListFactory givenProduct() {
        return new ProductListFactory(realProductRepository);
    }

    private List<Product> thenGetProductsFromApi() {
        return Lists.newArrayList(template.getForEntity("http://localhost:8080/api/v1/products", Product[].class).getBody());
    }

    private Product thenGetOneProductFromApi() {
        return template.getForEntity("http://localhost:8080/api/v1/products/product_0", Product.class).getBody();
    }

    private List<Product> thenGetNumberOfNewestProductsFromApi(int number) {
        return Lists.newArrayList(template.getForEntity(String.format("http://localhost:8080/api/v1/products?order=desc&limit=%s", number), Product[].class).getBody());
    }
}
