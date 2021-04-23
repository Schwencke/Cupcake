package web.commands;


import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.OrderMapper;
import business.services.OrderFacade;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowAllOrdersCommand extends CommandProtectedPage {

    protected OrderFacade orderFacade;
    List<Order> orderList;

    public ShowAllOrdersCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        int delete = Integer.parseInt(request.getParameter("delete"));

        if(delete != 0){
            orderFacade.updateStatus(delete, 3);
        }

        int userId = Integer.parseInt(request.getParameter("user_id"));
        orderList = orderFacade.getAllOrdersById(userId);
        session.setAttribute("orderlist", orderList);

        return pageToShow;
    }
}
