package tech.allegro.wildsnake.application.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tech.allegro.wildsnake.model.ProductDomain;
import tech.allegro.wildsnake.product.service.ProductService;

import java.util.List;

/**
 * Created by michalolszewki on 2015-12-06.
 */
@RestController
@RequestMapping(value = "api/v1/products")
public class ProductsController {
    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{productName}"
    )
    public ProductDomain getProduct(@PathVariable("productName") String productName) {
        return productService.getProduct(productName);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<ProductDomain> getProducts(@RequestParam(value = "limit", required = false) Integer limit, @RequestParam(value = "order", required = false) String sort) {
        return productService.getProducts(limit, sort);
    }

}
