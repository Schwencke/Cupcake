package web.commands;


import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.OrderMapper;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class findOrdersByIdCommand extends CommandProtectedPage {

    protected OrderFacade orderFacade;
    List<Order> orderList;
    public findOrdersByIdCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.orderFacade = new OrderFacade(database);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {


        HttpSession session = request.getSession();

        int userId = Integer.parseInt(request.getParameter("searchforuser"));
        orderList = orderFacade.getAllOrdersById(userId);
        session.setAttribute("searchorderlist", orderList);

        return pageToShow;
    }
}
