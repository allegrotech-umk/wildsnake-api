package tech.allegro.wildsnake.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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

    @CrossOrigin
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{productName}"
    )
    public ProductDomain getProduct(@PathVariable("productName") String productName) {
        return productService.getProduct(productName);
    }

    @CrossOrigin
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<ProductDomain> getProducts(
            @RequestParam(value = "limit", required = false) Integer limit,
            @RequestParam(value = "order", required = false) String sort,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "priceMin",required = false) Integer priceMin,
            @RequestParam(value = "priceMax",required = false) Integer priceMax
    ) {
        return productService.getProducts(limit, sort,name,priceMin,priceMax);
    }

    @CrossOrigin
    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            value = "/{productName}"
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(
            @PathVariable("productName") String productName,
            @RequestBody ProductDomain productDomain
    ) {
        productService.updateProduct(productName, productDomain);
    }

    @CrossOrigin
    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addProduct(
            @RequestBody ProductDomain productDomain
    ) {
        productService.createUniqueProduct(productDomain);
    }

    @CrossOrigin
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{productName}"
    )
    public void deleteProduct(@PathVariable("productName") String productNane) {
        productService.deleteProduct(productNane);
    }
}
