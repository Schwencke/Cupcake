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

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
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
