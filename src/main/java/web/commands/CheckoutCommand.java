package web.commands;

import business.entities.Cupcake;
import business.persistence.CakeMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class CheckoutCommand extends CommandUnprotectedPage {

    protected CakeMapper cakeMapper;
    private List<Cupcake> cupcakeList = new ArrayList<>();

    public CheckoutCommand(String pageToShow) {
        super(pageToShow);
        this.cakeMapper = new CakeMapper(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String topping = request.getParameter("topping");
        String bottom = request.getParameter("bottom");
        String[] toppingArray = topping.split(",");
        String[] bottomArray = bottom.split(",");
        int price = Integer.parseInt(toppingArray[1]) + Integer.parseInt(bottomArray[1]);
        topping = toppingArray[0];
        bottom = bottomArray[0];
        int amount = Integer.parseInt(request.getParameter("amount"));

        cupcakeList.add(new Cupcake(topping, bottom, price, amount));

        int priceTotal = 0;
        for (Cupcake cupcake : cupcakeList) {
            priceTotal += cupcake.getPrice() * cupcake.getAmount();
        }

        request.getSession().setAttribute("pricetotal", priceTotal);
        request.getSession().setAttribute("cupcakelist", cupcakeList);
        return pageToShow;
    }
}
