package tech.allegro.wildsnake.product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tech.allegro.wildsnake.product.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findFirst3ByOrderByIdDesc();

    Product findOneByName(String name);

    Page<Product> findAll(Pageable pageable);
}
