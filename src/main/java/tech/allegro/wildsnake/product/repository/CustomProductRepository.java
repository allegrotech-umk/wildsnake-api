package tech.allegro.wildsnake.product.repository;

import org.springframework.transaction.annotation.Transactional;
import tech.allegro.wildsnake.product.model.Product;

public interface CustomProductRepository {
    @Transactional
    Product createUniqueProduct(Product product);
}
