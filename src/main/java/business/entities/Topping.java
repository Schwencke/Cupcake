package business.entities;

public class Topping {
    int toppingId;
    String flavor;
    int price;

    public Topping(int toppingId, String flavor, int price) {
        this.toppingId = toppingId;
        this.flavor = flavor;
        this.price = price;
    }

    public int getToppingId() {
        return toppingId;
    }

    public String getFlavor() {
        return flavor;
    }

    public int getPrice() {
        return price;
    }
}
