package tech.allegro.wildsnake.productCategory.repository;

import org.springframework.beans.factory.annotation.Autowired;
import tech.allegro.wildsnake.productCategory.model.ProductCategory;

import java.util.Objects;


public class ProductCategoryRepositoryImpl implements CustomProductCategoryRepository {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public <S extends ProductCategory> S createUniqueProduct(S productCategory) {
        if (Objects.nonNull(productCategoryRepository) && productCategoryRepository.findOneByName
                (productCategory.getName()) == null) {
            return productCategoryRepository.save(productCategory);
        }
        return null;
    }
}
