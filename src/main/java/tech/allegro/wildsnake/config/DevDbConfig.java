package tech.allegro.wildsnake.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import tech.allegro.wildsnake.product.model.Product;
import tech.allegro.wildsnake.product.repository.ProductRepository;

import javax.annotation.PostConstruct;

@Configuration
@Profile("!prod")
public class DevDbConfig {

    @Autowired
    private ProductRepository repository;

    @PostConstruct
    public void populateDatabase() {
        repository.save(new Product("1Snake", "", "", 100));
        repository.save(new Product("2Snake", "", "", 120));
        repository.save(new Product("3Snake", "", "", 140));
        repository.save(new Product("4Snake", "", "", 160));
        repository.save(new Product("5Snake", "", "", 150));
        repository.save(new Product("6Snake", "", "", 100));
    }

}
