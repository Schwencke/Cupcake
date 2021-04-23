package web.commands;

import business.entities.Order;
import business.entities.OrderLine;
import business.entities.User;
import business.exceptions.UserException;
import business.services.OrderFacade;
import business.services.StatusFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class PaymentCommand extends CommandProtectedPage {

    private UserFacade userFacade;
    private OrderFacade orderFacade;
    private List<OrderLine> orderLineList;

    public PaymentCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.userFacade = new UserFacade(database);
        this.orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        user.setBalance(userFacade.getBalance(userId));

        int balance = user.getBalance();
        int priceTotal = (int) session.getAttribute("pricetotal");

        if (balance > priceTotal) {
            Order order = (Order) session.getAttribute("order");
            user.setBalance(balance - priceTotal);
            userFacade.updateBalance(userId, user.getBalance());
            orderFacade.updateStatusSuccess(order.getOrderId());
            request.getSession().removeAttribute("orderlinelist");
            request.getSession().removeAttribute("pricetotal");

            //TODO : PaymentstatusUpdater
        } else {
            request.setAttribute("error", "Sufficient funds required!");
            return "paymentpage";
        }
        return pageToShow;
    }
}
