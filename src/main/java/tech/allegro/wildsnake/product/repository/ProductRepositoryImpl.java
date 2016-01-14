package tech.allegro.wildsnake.product.repository;

import org.springframework.beans.factory.annotation.Autowired;
import tech.allegro.wildsnake.product.model.Product;

public class ProductRepositoryImpl implements CustomProductRepository {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createUniqueProduct(Product product) {
        if (productRepository.findOneByName(product.getName()) == null) {
            return productRepository.save(product);
        }
        return null;
    }
}
