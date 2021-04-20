package business.entities;

public class Cupcake {
    String topping;
    String bottom;
    int price;
    int amount;

    public Cupcake(String top, String bottom, int price, int amount) {
        this.topping = top;
        this.bottom = bottom;
        this.price = price;
        this.amount = amount;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
