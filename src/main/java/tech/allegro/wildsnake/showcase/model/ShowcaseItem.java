package tech.allegro.wildsnake.showcase.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ShowcaseItem {
    private final String title;
    private final String imageUrl;
    private final BigDecimal price;

    @JsonCreator
    public ShowcaseItem(
            @JsonProperty("title") String title,
            @JsonProperty("imageUrl") String imageUrl,
            @JsonProperty("price") BigDecimal price) {
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
