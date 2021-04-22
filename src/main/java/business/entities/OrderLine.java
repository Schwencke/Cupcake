package business.entities;

public class OrderLine {
    int orderId;
    String bottom;
    String topping;
    int price;
    int amount;

    public OrderLine(int orderId, String bottom, String topping, int price, int amount) {
        this.orderId = orderId;
        this.bottom = bottom;
        this.topping = topping;
        this.price = price;
        this.amount = amount;
    }

    public OrderLine(String bottom, String topping, int price, int amount) {
        this.bottom = bottom;
        this.topping = topping;
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

    public int getOrderId() { return orderId; }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
