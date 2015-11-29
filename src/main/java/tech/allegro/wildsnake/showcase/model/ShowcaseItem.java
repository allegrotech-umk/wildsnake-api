package tech.allegro.wildsnake.showcase.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ShowcaseItem {
    private final String title;
    private final String imageUrl;

    @JsonCreator
    public ShowcaseItem(@JsonProperty("title") String title, @JsonProperty("imageUrl") String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
