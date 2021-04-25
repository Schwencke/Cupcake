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

public class OrderHistoryCommand extends CommandProtectedPage {

    protected OrderFacade orderFacade;
    List<Order> orderList;
    public OrderHistoryCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        orderList = orderFacade.getAllOrdersById(userId);
        session.setAttribute("orderlist", orderList);

        return pageToShow;
    }
}
