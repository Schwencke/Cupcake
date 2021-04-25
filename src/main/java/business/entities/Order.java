package business.entities;

import java.sql.Timestamp;

public class Order {
    int orderId;
    int userId;
    int priceTotal;
    int statusId;
    Timestamp created;

    public Order() {
    }

    public Order(int userId, int priceTotal) {
        this.userId = userId;
        this.priceTotal = priceTotal;
    }

    public Order(int orderId, int userId, int priceTotal) {
        this.orderId = orderId;
        this.userId = userId;
        this.priceTotal = priceTotal;
    }

    public Order(int orderId, int userId, int priceTotal, int status_id, Timestamp created) {
        this.orderId = orderId;
        this.userId = userId;
        this.priceTotal = priceTotal;
        this.statusId = status_id;
        this.created = created;
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

    public int getStatusId() {
        return statusId;
    }

    public Timestamp getCreated() {
        return created;
    }
}
