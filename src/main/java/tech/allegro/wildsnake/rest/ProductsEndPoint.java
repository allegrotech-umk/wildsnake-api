package tech.allegro.wildsnake.rest;

import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/{name}",method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable(value = "name") String name) {
        productService.deleteProductByName(name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProductDomain addProduct(@RequestBody ProductDomain request) {
        ProductDomain product = request;
        return product;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.PUT)
    public void updateProduct(@PathVariable(value = "name") String name, @RequestBody ProductDomain productDomain) {
        productService.updateProduct(name, productDomain);
    }

}
