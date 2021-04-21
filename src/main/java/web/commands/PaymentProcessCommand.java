package web.commands;

import business.entities.User;
import business.exceptions.UserException;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PaymentProcessCommand extends CommandProtectedPage {

    private UserFacade userFacade;

    public PaymentProcessCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();

            User user = (User) session.getAttribute("user");
            int userId = user.getUserId();
            user.setBalance(userFacade.getBalance(userId));

            int balance = user.getBalance();
            int priceTotal = (int) session.getAttribute("pricetotal");

            if (balance > priceTotal) {
                user.setBalance(balance - priceTotal);
                userFacade.updateBalance(userId, user.getBalance());
//                session.setAttribute("balance", balance);
            }
        }  catch (UserException ex) {
            request.setAttribute("error", "Sufficient funds required!");
            return "paymentpage";
        }
        return pageToShow;
    }
}
