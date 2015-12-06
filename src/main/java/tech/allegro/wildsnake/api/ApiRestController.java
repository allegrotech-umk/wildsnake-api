package tech.allegro.wildsnake.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.allegro.wildsnake.product.model.Product;
import tech.allegro.wildsnake.product.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Szymon on 06.12.2015.
 */

@RestController
@RequestMapping("/api/v1")
public class ApiRestController {

    private ProductRepository productRepository;

    @Autowired
    public ApiRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getProducts(
            @RequestParam(value = "order", required = false) Optional<String> order,
            @RequestParam(value = "limit", required = false) Optional<Long> limit
    ) {
        if (order.isPresent() && limit.isPresent()) {
            if ("asc".equals(order.get())) {
                return productRepository.findFirst3ByOrderByIdAsc();
            } else if ("desc".equals(order.get())) {
                return productRepository.findFirst3ByOrderByIdDesc();
            }
        }

        return productRepository.findFirst3ByOrderByIdDesc();
    }

    @RequestMapping(value = "/product_{productId}", method = RequestMethod.GET)
    public Product getOneProduct(
            @PathVariable("productId") Optional<Long> productId) {
        if (productId.isPresent()) {
            return productRepository.findOne(productId.get());
        } else {
            return new Product();
        }
    }
}
