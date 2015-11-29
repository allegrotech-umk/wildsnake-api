package tech.allegro.wildsnake.showcase.model;

public class ShowcaseItem {
    private final String title;
    private final String imageUrl;
    private final int price;

    public ShowcaseItem(String title, String imageUrl, int price) {
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

    public int getPrice() {
        return price;
    }
}
