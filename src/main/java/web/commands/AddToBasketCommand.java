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
        String bottom = request.getParameter("bottom");
        String topping = request.getParameter("topping");
        String[] bottomArray = bottom.split(",");
        String[] toppingArray = topping.split(",");
        int price = Integer.parseInt(bottomArray[1]) + Integer.parseInt(toppingArray[1]);
        int bottomId = Integer.parseInt(bottomArray[2]);
        int toppingId = Integer.parseInt(toppingArray[2]);
        bottom = bottomArray[0];
        topping = toppingArray[0];
        int amount = Integer.parseInt(request.getParameter("amount"));

        if (orderLineList == null) {
            orderLineList = new ArrayList<>();
        }
        orderLineList.add(new OrderLine(bottom, bottomId, topping, toppingId, price, amount));

        int priceTotal = 0;
        for (OrderLine orderLine : orderLineList) {
            priceTotal += orderLine.getPrice() * orderLine.getAmount();
        }

        request.getSession().setAttribute("orderlinecount", orderLineList.size());
        request.getSession().setAttribute("pricetotal", priceTotal);
        request.getSession().setAttribute("orderlinelist", orderLineList);

        request.setAttribute("msg", "Cupcake tilføjet.");

        return pageToShow;
    }
}
