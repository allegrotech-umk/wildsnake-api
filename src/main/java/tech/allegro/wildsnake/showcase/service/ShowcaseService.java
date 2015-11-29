package tech.allegro.wildsnake.showcase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.allegro.wildsnake.product.model.Product;
import tech.allegro.wildsnake.product.repository.ProductRepository;
import tech.allegro.wildsnake.showcase.model.ShowcaseItem;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShowcaseService {

    private final ProductRepository productRepository;

    @Autowired
    public ShowcaseService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ShowcaseItem> getItems() {
        List<Product> productList = productRepository.findFirst3ByOrderByIdDesc();
        return prepareShowcaseItems(productList);
    }

    private List<ShowcaseItem> prepareShowcaseItems(List<Product> productList) {
        return productList.stream().map(
                product -> new ShowcaseItem(product.getName(), product.getImageUrl(), product.getPrice())
        ).collect(Collectors.toList());
    }
}
