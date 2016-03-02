package tech.allegro.wildsnake.product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tech.allegro.wildsnake.product.model.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>, CustomProductRepository {
    List<Product> findFirst3ByOrderByIdDesc();

    Product findOneByName(String name);

    Page<Product> findAll(Pageable pageable);

    @Transactional
    Long deleteByName(String name);

    @Transactional
    @Modifying
    @Query("update Product p set p.imageUrl = ?1, p.description = ?2, p.price = ?3 where p.name = ?4")
    int updateProduct(String imagerUrl, String description, BigDecimal price, String name);

}
