package web.commands;

import business.entities.User;
import business.exceptions.UserException;
import business.persistence.UserMapper;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class BalanceUpdateCommand extends CommandProtectedPage {

    private UserFacade userFacade;

    public BalanceUpdateCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        int userId = Integer.parseInt(request.getParameter("user_id"));
        int newBalance = Integer.parseInt(request.getParameter("user_balance"));
        userFacade.updateBalance(userId, newBalance);

        HttpSession session = request.getSession();

        List<User> userList = userFacade.getAllUsers();
        session.setAttribute("userlist", userList);

        request.setAttribute("msg", "Saldoen er blevet opdateret.");

        return pageToShow;
    }
}
