package tech.allegro.wildsnake.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.allegro.wildsnake.model.ProductDomain;
import tech.allegro.wildsnake.product.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsEndPoint {

    private final ProductService productService;

    @Autowired
    public ProductsEndPoint(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{productName}"
    )
    public ProductDomain getProduct(@PathVariable("productName") String productName) {
        return productService.getProduct(productName);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<ProductDomain> getProducts(
            @RequestParam(value = "limit", required = false) Integer limit,
            @RequestParam(value = "order", required = false) String sort
    ) {
        return productService.getProducts(limit, sort);
    }
}
