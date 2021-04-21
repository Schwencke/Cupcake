package web.commands;

import business.persistence.CakeMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasketCommand extends CommandUnprotectedPage {

    protected CakeMapper cakeMapper;

    public BasketCommand(String pageToShow) {
        super(pageToShow);
        this.cakeMapper = new CakeMapper(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return pageToShow;
    }
}
