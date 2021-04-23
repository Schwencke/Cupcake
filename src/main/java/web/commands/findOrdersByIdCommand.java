package web.commands;


import business.persistence.OrderMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class findOrdersByIdCommand extends CommandProtectedPage {

    protected OrderMapper orderMapper;

    public findOrdersByIdCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.orderMapper = new OrderMapper(database);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        //TODO: find orders by uderID and map to list.

        return pageToShow;
    }
}
