package tech.allegro.wildsnake.showcase.model;

import java.math.BigDecimal;

public class ShowcaseItem {
    private final String title;
    private final String imageUrl;
    private final BigDecimal price;

    public ShowcaseItem(String title, String imageUrl, BigDecimal price) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
