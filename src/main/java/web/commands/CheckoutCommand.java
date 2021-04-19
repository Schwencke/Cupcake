package web.commands;

import business.entities.Cupcake;
import business.persistence.CakeMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class CheckoutCommand extends CommandProtectedPage {

    CakeMapper cakeMapper;

    public CheckoutCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.cakeMapper = new CakeMapper(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String topping = request.getParameter("topping");
        String bottom = request.getParameter("bottom");
        int price = Integer.parseInt(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));

        Cupcake cupcake = new Cupcake(topping, bottom, amount, price);
        
        List<Cupcake> cupcakeList = null;

        if (cupcakeList != null) {
            cupcakeList.add(cupcake);
        } else {
            cupcakeList = new ArrayList<>();
            cupcakeList.add(cupcake);
        }

        request.setAttribute("cupcakelist", cupcakeList);

        return pageToShow;
    }
}
