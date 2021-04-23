package web.commands;

import business.entities.Order;
import business.entities.User;
import business.persistence.UserMapper;
import business.services.OrderFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeCommand extends CommandProtectedPage {

    private UserFacade userFacade;
    private OrderFacade orderFacade;
    Order order;

    public EmployeeCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.userFacade = new UserFacade(database);
        this.orderFacade = new OrderFacade(database);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");



        int userId = user.getUserId();
        String firstname = user.getFirstname();
        String lastname = user.getLastname();
        String phoneNo = user.getPhoneNo();
        String email = user.getEmail();
        int saldo = user.getBalance();

        return pageToShow;
    }
}
