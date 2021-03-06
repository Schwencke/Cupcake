package web.commands;

import business.entities.User;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class LoginCommand extends CommandUnprotectedPage {
    private UserFacade userFacade;

    public LoginCommand(String pageToShow) {
        super(pageToShow);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            User user = userFacade.login(email, password);

            HttpSession session = request.getSession();

            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            session.setAttribute("email", email);

            String pageToShow;

            if (session.getAttribute("orderlinelist") != null) {
                pageToShow = "checkoutpage";
            } else if (user.getRole() != null) {
                pageToShow = user.getRole() + "page";
            } else {
                session.invalidate();
                request.setAttribute("error", "Wrong username or password!");
                pageToShow = "loginpage";
                throw new UserException("Wrong username or password");
            }
            return REDIRECT_INDICATOR + pageToShow;
        } catch (UserException | SQLException ex) {
            request.setAttribute("error", "Wrong username or password!");
            return "loginpage";
        }
    }

}
