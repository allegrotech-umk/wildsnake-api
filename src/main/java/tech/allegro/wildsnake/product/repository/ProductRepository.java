package tech.allegro.wildsnake.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.allegro.wildsnake.product.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findFirst3ByOrderByIdAsc();
}
