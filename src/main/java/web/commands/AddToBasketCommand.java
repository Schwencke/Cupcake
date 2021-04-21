package web.commands;

import business.entities.OrderLine;
import business.persistence.CakeMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AddToBasketCommand extends CommandUnprotectedPage {

    protected CakeMapper cakeMapper;
    List<OrderLine> orderLineList;

    public AddToBasketCommand(String pageToShow) {
        super(pageToShow);
        this.cakeMapper = new CakeMapper(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        orderLineList = (List<OrderLine>) session.getAttribute("orderlinelist");

        String topping = request.getParameter("topping");
        String bottom = request.getParameter("bottom");
        String[] toppingArray = topping.split(",");
        String[] bottomArray = bottom.split(",");
        int price = Integer.parseInt(toppingArray[1]) + Integer.parseInt(bottomArray[1]);
        topping = toppingArray[0];
        bottom = bottomArray[0];
        int amount = Integer.parseInt(request.getParameter("amount"));

        if (orderLineList == null) {
            orderLineList = new ArrayList<>();
        }
        orderLineList.add(new OrderLine(topping, bottom, price, amount));

        int priceTotal = 0;
        for (OrderLine orderLine : orderLineList) {
            priceTotal += orderLine.getPrice() * orderLine.getAmount();
        }

        request.getSession().setAttribute("pricetotal", priceTotal);
        request.getSession().setAttribute("orderlinelist", orderLineList);

        request.setAttribute("msg", "Cupcake tilføjet.");

        return pageToShow;
    }
}
