package web.commands;

import business.entities.Bottom;
import business.entities.OrderLine;
import business.entities.Topping;
import business.exceptions.UserException;
import business.persistence.CakeMapper;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AddToBasketCommand extends CommandUnprotectedPage {
    protected CakeMapper cakeMapper;
    List<OrderLine> orderLineList;
    List<Bottom> bottomList;
    List<Topping> toppingList;
    int orderLineId;

    public AddToBasketCommand(String pageToShow) {
        super(pageToShow);
        this.cakeMapper = new CakeMapper(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();

        orderLineList = (List<OrderLine>) session.getAttribute("orderlinelist");
        String bottom = request.getParameter("bottom");
        String topping = request.getParameter("topping");

        ServletContext application = request.getServletContext();
        bottomList = (List<Bottom>) application.getAttribute("bottomlist");
        toppingList = (List<Topping>) application.getAttribute("toppinglist");

        int bottomId = Integer.parseInt(bottom)-1;
        int toppingId = Integer.parseInt(topping)-1;

        bottom = bottomList.get(bottomId).getFlavor();
        topping = toppingList.get(toppingId).getFlavor();

        int price = bottomList.get(bottomId).getPrice() + toppingList.get(toppingId).getPrice();
        int amount = Integer.parseInt(request.getParameter("amount"));

        if (orderLineList == null) {
            orderLineList = new ArrayList<>();
            orderLineId = 0;
        }
        orderLineId++;
        orderLineList.add(new OrderLine(orderLineId, bottom, bottomId, topping, toppingId, price, amount));

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
