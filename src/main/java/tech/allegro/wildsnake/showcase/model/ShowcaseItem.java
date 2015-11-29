package tech.allegro.wildsnake.showcase.model;

public class ShowcaseItem {
    private final String title;
    private final String imageUrl;
    private final long price;

    public ShowcaseItem(String title, String imageUrl, long price) {
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

    public long getPrice() {
        return price;
    }
}
