package tech.allegro.wildsnake.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import tech.allegro.wildsnake.product.model.Product;
import tech.allegro.wildsnake.product.repository.ProductRepository;
import tech.allegro.wildsnake.productCategory.model.ProductCategory;
import tech.allegro.wildsnake.productCategory.repository.ProductCategoryRepository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Configuration
@Profile("!prod")
public class DevDbConfig {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @PostConstruct
    public void populateDatabase() {
        productCategoryRepository.save(new ProductCategory("Gady"));
        ProductCategory productCategory = productCategoryRepository.findOneByName("Gady");

        productRepository.save(new Product("1Snake", "", "", BigDecimal.TEN, productCategory));
        productRepository.save(new Product("2Snake", "", "", BigDecimal.TEN, productCategory));
        productRepository.save(new Product("3Snake", "", "", BigDecimal.TEN, productCategory));
        productRepository.save(new Product("4Snake", "", "", BigDecimal.TEN, productCategory));
        productRepository.save(new Product("5Snake", "", "", BigDecimal.TEN, productCategory));
        productRepository.save(new Product("6Snake", "", "", BigDecimal.TEN, productCategory));
    }

}
