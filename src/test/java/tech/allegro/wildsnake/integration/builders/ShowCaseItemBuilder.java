package tech.allegro.wildsnake.integration.builders;

import tech.allegro.wildsnake.showcase.model.ShowcaseItem;

import java.math.BigDecimal;

/**
 * Created by Admin on 2015-12-03.
 */
public class ShowCaseItemBuilder {
    private int numberOfInstances = 1;

    private String title;
    private String imageUrl = "http://localhost/image";
    ;
    private BigDecimal price;

    public ShowCaseItemBuilder(String title) {
        this.title = title;
    }

    public ShowCaseItemBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ShowcaseItem build() {
        return new ShowcaseItem(title, imageUrl, price);
    }

}
