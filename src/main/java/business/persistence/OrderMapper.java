package business.persistence;

import business.entities.Order;
import business.entities.OrderLine;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    private final Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }

    public Order createOrder(Order order) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO `order` (user_id, price_total) VALUES (?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, order.getUserId());
                ps.setInt(2, order.getPriceTotal());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int orderId = ids.getInt(1);
                order.setOrderId(orderId);

                return order;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public void createOrderLine(OrderLine orderLine) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO `order_line` (order_id, quantity, bottom_id, topping_id) VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, orderLine.getOrderId());
                ps.setInt(2, orderLine.getAmount());
                ps.setInt(3, orderLine.getBottomId());
                ps.setInt(4, orderLine.getToppingId());
                ps.executeUpdate();
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public void updateStatusSuccess(int orderId) throws UserException{

        try (Connection connection = database.connect()) {
            String sql = "UPDATE `order` SET `status_id`=? WHERE `order_id`=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, 2);
                ps.setInt(2, orderId);
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }


    public List<Order> getAllOrders() throws UserException {
        List<Order> orderList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM `order`";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderId = rs.getInt("order_id");
                    int userId = rs.getInt("user_id");
                    int priceTotal = rs.getInt("price_total");
                    orderList.add(new Order(orderId, userId, priceTotal));
                }
                return orderList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public List<Order> getAllOrdersById(int userId) throws UserException {
        List<Order> orderList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM `order` WHERE `user_id` = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, userId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderId = rs.getInt("order_id");
                    int priceTotal = rs.getInt("price_total");
                    int statusId = rs.getInt("status_id");
                    Timestamp created = rs.getTimestamp("created");
                    orderList.add(new Order(orderId, userId, priceTotal, statusId, created));
                }
                return orderList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public List<OrderLine> getAllOrderLinesById(int orderId) throws UserException {
        List<OrderLine> orderLineList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM `order_line` WHERE `order_id` = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int quantity = rs.getInt("quantity");
                    int bottomId = rs.getInt("bottom");
                    int toppingId = rs.getInt("topping");
                    orderLineList.add(new OrderLine(orderId, bottomId, toppingId, quantity));
                }
                return  orderLineList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }
}
