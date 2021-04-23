package web.commands;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.UserMapper;
import business.services.OrderFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();

        List<User> userList = userFacade.getAllUsers();
        session.setAttribute("userlist", userList);

        return pageToShow;
    }
}
