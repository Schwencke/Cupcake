package web.commands;

import business.exceptions.UserException;
import business.persistence.Database;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public abstract class Command {
    public final static String REDIRECT_INDICATOR = "#*redirect*#_###_";

    private static HashMap<String, Command> commands;
    public static Database database;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("index", new CommandUnprotectedPage("index"));
        commands.put("loginpage", new CommandUnprotectedPage("loginpage"));
        commands.put("logincommand", new LoginCommand(""));
        commands.put("logoutcommand", new LogoutCommand(""));
        commands.put("registerpage", new CommandUnprotectedPage("registerpage"));
        commands.put("registercommand", new RegisterCommand(""));
        commands.put("customerpage", new CommandProtectedPage("customerpage", "customer"));
        commands.put("employeepage", new CommandProtectedPage("employeepage", "employee"));
        commands.put("basketpage", new BasketCommand("basketpage"));
        commands.put("addtobasketcommand", new AddToBasketCommand("index"));
        commands.put("checkoutpage", new CheckoutCommand("checkoutpage", "customer"));
        commands.put("paymentpage", new PaymentCommand("paymentpage", "customer"));
        commands.put("orderhistorypage", new OrderHistoryCommand("orderhistorypage", "customer"));
        commands.put("orderspage", new EmployeeCommand("admin_orderspage", "employee"));
        commands.put("userspage", new EmployeeCommand("admin_userspage", "employee"));
        commands.put("showallorders", new ShowAllOrdersCommand("admin_orderspage", "employee"));
        commands.put("balanceupdate", new BalanceUpdateCommand("admin_userspage", "employee"));
        commands.put("removefrombasketcommand", new RemoveFromBasketCommand("basketpage"));
    }

    public static Command fromPath(
            HttpServletRequest request,
            Database db) {
        String action = request.getPathInfo().replaceAll("^/+", "");
        System.out.println("--> " + action);

        if (commands == null) {
            database = db;
            initCommands();
        }

        return commands.getOrDefault(action, new CommandUnknown());   // unknowncommand is default
    }

    public abstract String execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws UserException;
}
