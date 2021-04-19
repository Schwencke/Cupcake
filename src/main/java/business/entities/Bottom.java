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

    public void setBottomId(int bottomId) {
        this.bottomId = bottomId;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
