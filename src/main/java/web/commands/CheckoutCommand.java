package web.commands;

import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckoutCommand extends CommandProtectedPage {

    private UserFacade userFacade;

    public CheckoutCommand(String pageToShow, String role) {
        super(pageToShow, role);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {




        return pageToShow;
    }
}
