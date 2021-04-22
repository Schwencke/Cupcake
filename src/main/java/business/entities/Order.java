package business.entities;

import java.sql.Timestamp;

public class Order {
    int orderId;
    int userId;
    int priceTotal;
    int status_id;
    Timestamp created;

    public Order(int orderId, int userId, int priceTotal) {
        this.orderId = orderId;
        this.userId = userId;
        this.priceTotal = priceTotal;
    }

    public Order(int orderId, int userId, int priceTotal, int status_id, Timestamp created) {
        this.orderId = orderId;
        this.userId = userId;
        this.priceTotal = priceTotal;
        this.status_id = status_id;
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

    public void setPriceTotal(int priceTotal) {
        this.priceTotal = priceTotal;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
