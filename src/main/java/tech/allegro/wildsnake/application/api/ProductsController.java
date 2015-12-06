package tech.allegro.wildsnake.application.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.allegro.wildsnake.product.model.Product;
import tech.allegro.wildsnake.product.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by michalolszewki on 2015-12-06.
 */
@RestController
@RequestMapping(value = "api/v1/products")
public class ProductsController {
    @Autowired
    ProductRepository productRepository;

    private Iterable<Product> productList = new ArrayList<>();

    @RequestMapping(value = "")
    public Iterable<Product> getProducts(@RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "order", required = false) String order) {
        productList = productRepository.findAll();

        List<Product> result = StreamSupport.stream(productList.spliterator(), false).collect(Collectors.toCollection(ArrayList::new));
        if ("desc".equals(order)) {
            Collections.reverse(result);
        }

        if (limit != null) {
            result = result.stream().limit(limit).collect(Collectors.toList());

        }
        return result;
    }

    @RequestMapping(value = "/{productName}")
    public Product getProductByName(@PathVariable("productName") String productName) {
        return productRepository.findOneByName(productName);
    }

}
