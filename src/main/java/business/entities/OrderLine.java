package business.entities;

public class OrderLine {
    String topping;
    String bottom;
    int price;
    int amount;

    public OrderLine(String top, String bottom, int price, int amount) {
        this.topping = top;
        this.bottom = bottom;
        this.price = price;
        this.amount = amount;
    }

    public String getTopping() {
        return topping;
    }

    public String getBottom() {
        return bottom;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
