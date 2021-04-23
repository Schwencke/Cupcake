package business.entities;

public class OrderLine {
    int orderId;
    String bottom;
    int bottomId;
    String topping;
    int toppingId;
    int price;
    int amount;

    public OrderLine(String bottom, int bottomId, String topping, int toppingId, int price, int amount) {
        this.bottom = bottom;
        this.bottomId = bottomId;
        this.topping = topping;
        this.toppingId = toppingId;
        this.price = price;
        this.amount = amount;
    }

    public OrderLine(int orderId, String bottom, String topping, int price, int amount) {
        this.orderId = orderId;
        this.bottom = bottom;
        this.topping = topping;
        this.price = price;
        this.amount = amount;
    }

    public OrderLine(int orderId, int bottomId, int toppingId, int amount) {
        this.orderId = orderId;
        this.bottomId = bottomId;
        this.toppingId = toppingId;
        this.amount = amount;
    }

    public int getBottomId() {
        return bottomId;
    }

    public void setBottomId(int bottomId) {
        this.bottomId = bottomId;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
