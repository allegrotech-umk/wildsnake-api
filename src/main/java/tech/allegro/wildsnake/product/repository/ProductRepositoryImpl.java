package tech.allegro.wildsnake.product.repository;

import org.springframework.beans.factory.annotation.Autowired;
import tech.allegro.wildsnake.product.model.Product;

import java.util.Objects;

final public class ProductRepositoryImpl implements CustomProductRepository {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public <S extends Product> S createUniqueProduct(S product) {
        if (Objects.nonNull(productRepository) && productRepository.findOneByName(product.getName()) == null) {
            return productRepository.save(product);
        }
        return null;
    }
}
