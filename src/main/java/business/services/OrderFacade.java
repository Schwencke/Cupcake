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

    public List<Order> getAllOrders() throws UserException {
        return getAllOrders();
    }

    public List<Order> getAllOrdersById(int userId) throws UserException {
        return  getAllOrdersById(userId);
    }

    public List<OrderLine> getAllOrderLinesById(int orderId) throws UserException {
        return getAllOrderLinesById(orderId);
    }
}
