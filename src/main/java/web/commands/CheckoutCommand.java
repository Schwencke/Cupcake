package web.commands;

import business.entities.Cupcake;
import business.persistence.CakeMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CheckoutCommand extends CommandUnprotectedPage {

    protected CakeMapper cakeMapper;

    public CheckoutCommand(String pageToShow) {
        super(pageToShow);
        this.cakeMapper = new CakeMapper(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
         return pageToShow;
    }
}
