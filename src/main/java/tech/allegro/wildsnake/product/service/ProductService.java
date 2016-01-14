package tech.allegro.wildsnake.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tech.allegro.wildsnake.model.ProductDomain;
import tech.allegro.wildsnake.product.model.Product;
import tech.allegro.wildsnake.product.repository.ProductRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private static int PAGE_LIMIT = 20;
    private static int FIRST_PAGE = 0;
    private static String DEFAULT_SORT_BY_NAME = "name";

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDomain getProduct(final String productName) {
        return new ProductDomain(productRepository.findOneByName(productName));
    }

    public List<ProductDomain> getProducts(final Integer size, final String sort) {
        PageRequest pageRequest = new PageRequest(FIRST_PAGE, setReturnSize(size), setSortDirection(sort), DEFAULT_SORT_BY_NAME);
        return productRepository.findAll(pageRequest).getContent().stream().map(ProductDomain::new).collect(Collectors.toList());
    }

    public void deleteProduct(final String productName) {
        productRepository.deleteByName(productName);
    }

    public void createProduct(final ProductDomain productDomain) {
        productRepository.createUniqueProduct(new Product(
                productDomain.getName(),
                productDomain.getImageUrl(),
                productDomain.getDescription(),
                productDomain.getPrice()));
    }

    public void updateProduct(final String productName, final ProductDomain productDomain) {
        productRepository.updateProduct(
                productDomain.getImageUrl(),
                productDomain.getDescription(),
                productDomain.getPrice(),
                productName);
    }

    private int setReturnSize(final Integer size) {
        return (Objects.isNull(size) ? PAGE_LIMIT : size.intValue());
    }

    private Sort.Direction setSortDirection(final String sort) {
        return (StringUtils.isEmpty(sort) ? null : Sort.Direction.fromString(sort));
    }

}
