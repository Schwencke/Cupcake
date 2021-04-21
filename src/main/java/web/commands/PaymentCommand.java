package web.commands;

import business.entities.OrderLine;
import business.entities.User;
import business.exceptions.UserException;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class PaymentCommand extends CommandProtectedPage {

    private UserFacade userFacade;
    private List<OrderLine> orderLineList;

    public PaymentCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.userFacade = new UserFacade(database);
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
            user.setBalance(balance - priceTotal);
            userFacade.updateBalance(userId, user.getBalance());
            System.out.println(orderLineList);
            request.getSession().removeAttribute("orderlinelist");
            request.getSession().removeAttribute("pricetotal");
        } else {
            request.setAttribute("error", "Sufficient funds required!");
            return "paymentpage";
        }
        return pageToShow;
    }
}
