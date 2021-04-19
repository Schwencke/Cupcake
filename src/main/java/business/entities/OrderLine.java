package business.entities;

public class OrderLine {
    Bottom bottom;
    Topping topping;
    int quantity;
    int price;

    public OrderLine(Bottom bottom, Topping topping, int amount, int price) {
        this.bottom = bottom;
        this.topping = topping;
        this.quantity = amount;
        this.price = price;
    }

    public Bottom getBottom() {
        return bottom;
    }

    public void setBottom(Bottom bottom) {
        this.bottom = bottom;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
