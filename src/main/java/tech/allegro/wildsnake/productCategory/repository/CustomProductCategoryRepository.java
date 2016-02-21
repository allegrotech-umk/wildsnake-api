package tech.allegro.wildsnake.productCategory.repository;


import tech.allegro.wildsnake.productCategory.model.ProductCategory;

import javax.transaction.Transactional;

public interface CustomProductCategoryRepository {
    @Transactional
    <S extends ProductCategory> S createUniqueProduct(S ProductCategory);
}
