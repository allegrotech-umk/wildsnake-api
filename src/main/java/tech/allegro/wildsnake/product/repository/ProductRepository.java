package tech.allegro.wildsnake.product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tech.allegro.wildsnake.product.model.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findFirst3ByOrderByIdDesc();

    Product findOneByName(String name);

    Page<Product> findAll(Pageable pageable);

    @Query("update Product p set p.name = ?1, p.imageUrl = ?2, p.description = ?3, p.price = ?4 where p.name = ?5")
    void updateProduct(String name, String imageUrl, String description, BigDecimal price, final String prevName);

}
