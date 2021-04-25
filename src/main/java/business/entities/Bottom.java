package business.entities;

public class Bottom {
    int bottomId;
    String flavor;
    int price;

    public Bottom(int bottomId, String flavor, int price) {
        this.bottomId = bottomId;
        this.flavor = flavor;
        this.price = price;
    }

    public int getBottomId() {
        return bottomId;
    }

    public String getFlavor() {
        return flavor;
    }

    public int getPrice() {
        return price;
    }
}
