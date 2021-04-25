package business.services;

import business.entities.Order;
import business.entities.OrderLine;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;


import java.util.List;

public class OrderFacade {
    private OrderMapper orderMapper;

    public OrderFacade(Database database) {
        this.orderMapper = new OrderMapper(database);
    }

    public Order createOrder(Order order) throws UserException {
        return orderMapper.createOrder(order);
    }

    public void createOrderLine(OrderLine orderLine) throws UserException {
        orderMapper.createOrderLine(orderLine);
    }

    public List<Order> getAllOrders() throws UserException {
        return orderMapper.getAllOrders();
    }

    public List<Order> getAllOrdersById(int userId) throws UserException {
        return orderMapper.getAllOrdersById(userId);
    }

    public List<OrderLine> getAllOrderLinesById(int orderId) throws UserException {
        return orderMapper.getAllOrderLinesById(orderId);
    }

    public void updateStatus(int orderId, int statusId) throws UserException{
        orderMapper.updateStatus(orderId, statusId);
    }
}
