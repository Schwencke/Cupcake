package web.commands;

import business.persistence.UserMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaymentProcessCommand extends CommandProtectedPage {

    protected UserMapper userMapper;

    public PaymentProcessCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.userMapper = new UserMapper(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return pageToShow;
    }
}
