package tech.allegro.wildsnake.productCategory.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tech.allegro.wildsnake.productCategory.model.ProductCategory;

@Repository
public interface ProductCategoryRepository extends PagingAndSortingRepository<ProductCategory,
        Long>, CustomProductCategoryRepository {

    @Transactional
    Long deleteByName(String name);

    ProductCategory findOneByName(String name);

    Page<ProductCategory> findAll(Pageable pageable);

    @Transactional
    @Modifying
    @Query("update ProductCategory p set p.name = ?1 where p.name = ?2")
    int updateProduct(String newName, String oldName);

}
