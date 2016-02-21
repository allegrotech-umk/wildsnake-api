package tech.allegro.wildsnake.productCategory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tech.allegro.wildsnake.model.ProductCategoryDomain;
import tech.allegro.wildsnake.product.repository.ProductRepository;
import tech.allegro.wildsnake.productCategory.model.ProductCategory;
import tech.allegro.wildsnake.productCategory.repository.ProductCategoryRepository;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductCategoryService {

    private static int PAGE_LIMIT = 20;
    private static String DEFAULT_SORT_BY_NAME = "name";

    private final ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryService(ProductRepository productRepository, ProductCategoryRepository
            productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }


    public ProductCategoryDomain getProductCategory(final String categoryName) {
        return new ProductCategoryDomain(productCategoryRepository.findOneByName(categoryName));
    }

    public Set<ProductCategoryDomain> getProducts(final Integer size, final String sort, final
    Integer pageNumber) {
        PageRequest pageRequest = new PageRequest(pageNumber - 1, setReturnSize(size),
                setSortDirection(sort), DEFAULT_SORT_BY_NAME);
        return productCategoryRepository.findAll(pageRequest).getContent().stream().map
                (ProductCategoryDomain::new).collect(Collectors.toSet());
    }

    public void createUniqueProductCategory(final String categoryName) {
        productCategoryRepository.createUniqueProduct(new ProductCategory(categoryName));
    }


    private int setReturnSize(final Integer size) {
        return (Objects.isNull(size) ? PAGE_LIMIT : size.intValue());
    }

    private Sort.Direction setSortDirection(final String sort) {
        return (StringUtils.isEmpty(sort) ? null : Sort.Direction.fromString(sort));
    }
}
