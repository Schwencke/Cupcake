package web.commands;

import business.entities.User;
import business.persistence.UserMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeCommand extends CommandProtectedPage {

    protected UserMapper userMapper;

    public EmployeeCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.userMapper = new UserMapper(database);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {


        return pageToShow;
    }
}
