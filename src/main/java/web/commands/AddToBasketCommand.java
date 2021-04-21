package web.commands;

import business.entities.Cupcake;
import business.persistence.CakeMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AddToBasketCommand extends CommandUnprotectedPage {

    protected CakeMapper cakeMapper;
    List<Cupcake> cupcakeList;

    public AddToBasketCommand(String pageToShow) {
        super(pageToShow);
        this.cakeMapper = new CakeMapper(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        cupcakeList = (List<Cupcake>) session.getAttribute("cupcakelist");

        String topping = request.getParameter("topping");
        String bottom = request.getParameter("bottom");
        String[] toppingArray = topping.split(",");
        String[] bottomArray = bottom.split(",");
        int price = Integer.parseInt(toppingArray[1]) + Integer.parseInt(bottomArray[1]);
        topping = toppingArray[0];
        bottom = bottomArray[0];
        int amount = Integer.parseInt(request.getParameter("amount"));

        if (cupcakeList == null) {
            cupcakeList = new ArrayList<>();
        }
        cupcakeList.add(new Cupcake(topping, bottom, price, amount));

        int priceTotal = 0;
        for (Cupcake cupcake : cupcakeList) {
            priceTotal += cupcake.getPrice() * cupcake.getAmount();
        }

        request.getSession().setAttribute("pricetotal", priceTotal);
        request.getSession().setAttribute("cupcakelist", cupcakeList);

        request.setAttribute("msg", "Cupcake tilføjet.");

        return pageToShow;
    }
}
