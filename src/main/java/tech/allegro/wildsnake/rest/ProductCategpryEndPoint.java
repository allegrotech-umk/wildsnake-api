package tech.allegro.wildsnake.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tech.allegro.wildsnake.model.ProductCategoryDomain;
import tech.allegro.wildsnake.productCategory.service.ProductCategoryService;

@RestController
@RequestMapping("/api/v1/productCategories")
public class ProductCategpryEndPoint {

    private final ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategpryEndPoint(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addProductCategory(
            @RequestBody ProductCategoryDomain productCategoryDomain
    ) {
        productCategoryService.createUniqueProductCategory(productCategoryDomain.getName());
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/{productCategoryName}"
    )
    public ProductCategoryDomain getOneCategory(@PathVariable("productCategoryName") String
                                                        productCategoryName) {
        return productCategoryService.getProductCategory(productCategoryName);
    }
}
