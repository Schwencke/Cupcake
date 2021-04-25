package web.commands;

import business.entities.OrderLine;
import business.persistence.CakeMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class RemoveFromBasketCommand extends CommandUnprotectedPage {

    protected CakeMapper cakeMapper;
    List<OrderLine> orderLineList;

    public RemoveFromBasketCommand(String pageToShow) {
        super(pageToShow);
        this.cakeMapper = new CakeMapper(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        orderLineList = (List<OrderLine>) session.getAttribute("orderlinelist");
        int delete = Integer.parseInt(request.getParameter("delete"));

        orderLineList.removeIf(orderLine -> orderLine.getOrderLineId() == delete);

        int priceTotal = 0;
        for (OrderLine orderLine : orderLineList) {
            priceTotal += orderLine.getPrice() * orderLine.getAmount();
        }

        session.setAttribute("orderlinelist", orderLineList);
        request.getSession().setAttribute("orderlinecount", orderLineList.size());
        request.getSession().setAttribute("pricetotal", priceTotal);


        return pageToShow;
    }
}
