package web.commands;

import business.entities.Order;
import business.entities.OrderLine;
import business.entities.User;
import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CheckoutCommand extends CommandProtectedPage {
    Order order;
    private OrderFacade orderFacade;

    public CheckoutCommand(String pageToShow, String role) {
        super(pageToShow, role);
        orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        int priceTotal = (int) session.getAttribute("pricetotal");
        session.setAttribute("order", orderFacade.createOrder(new Order(userId, priceTotal)));
        order = (Order) session.getAttribute("order");
        List<OrderLine> orderLineList = (List<OrderLine>) session.getAttribute("orderlinelist");
        for (OrderLine orderLine : orderLineList) {
            orderLine.setOrderId(order.getOrderId());
        }
        for (OrderLine orderLine : orderLineList) {
            orderFacade.createOrderLine(orderLine);

        }

        return pageToShow;
    }
}
