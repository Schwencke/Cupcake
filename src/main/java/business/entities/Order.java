package business.entities;

public class Order {
    int orderId;
    int userId;
    int priceTotal;
    Status status;

    public Order(int orderId, int userId, int priceTotal) {
        this.orderId = orderId;
        this.userId = userId;
        this.priceTotal = priceTotal;
    }

    public Order(int orderId, int userId, int priceTotal, Status status) {
        this.orderId = orderId;
        this.userId = userId;
        this.priceTotal = priceTotal;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(int priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
