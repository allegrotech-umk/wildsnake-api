package tech.allegro.wildsnake.batch;

import org.springframework.batch.item.ItemProcessor;
import tech.allegro.wildsnake.model.ProductDomain;
import tech.allegro.wildsnake.product.model.Product;


public class ProductItemProcessor implements ItemProcessor<ProductDomain, Product> {

    @Override
    public Product process(final ProductDomain productDomain) throws Exception {
        return new Product(productDomain.getName(), productDomain.getImageUrl(), productDomain.getDescription(), productDomain.getPrice());

    }
}
