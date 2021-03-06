package web;

import business.entities.Bottom;
import business.entities.Role;
import business.entities.Status;
import business.entities.Topping;
import business.exceptions.UserException;
import business.persistence.Database;
import business.services.CakeFacade;
import business.services.RoleFacade;
import business.services.StatusFacade;
import web.commands.Command;
import web.commands.CommandUnknown;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "FrontController", urlPatterns = {"/fc/*"})
public class FrontController extends HttpServlet {
    private final static String USER = "root";
    private final static String PASSWORD = "1234";
    private final static String URL = "jdbc:mysql://localhost:3306/cupcake?serverTimezone=CET";

    public static Database database;

    public void init() throws ServletException {
        // Initialize database connection
        if (database == null) {
            try {
                database = new Database(USER, PASSWORD, URL);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger("web").log(Level.SEVERE, ex.getMessage(), ex);
            }
        }

        // Initialize whatever global datastructures needed here:
        ServletContext application = getServletContext();

        CakeFacade cakeFacade = new CakeFacade(database);
        List<Topping> toppingList;
        try {
            toppingList = cakeFacade.getAllToppings();
        } catch (UserException ex) {
            throw new ServletException(ex.getMessage());
        }
        application.setAttribute("toppinglist", toppingList);

        List<Bottom> bottomList;
        try {
            bottomList = cakeFacade.getAllBottoms();
        } catch (UserException ex) {
            throw new ServletException(ex.getMessage());
        }
        application.setAttribute("bottomlist", bottomList);

        StatusFacade statusFacade = new StatusFacade(database);
        List<Status> statusList;
        try {
            statusList = statusFacade.getAllStatus();
        } catch (UserException ex) {
            throw new ServletException(ex.getMessage());
        }
        application.setAttribute("statuslist", statusList);

        RoleFacade roleFacade = new RoleFacade(database);
        List<Role> roleList;
        try {
            roleList = roleFacade.getAllRoles();
        } catch (UserException ex) {
            throw new ServletException(ex.getMessage());
        }
        application.setAttribute("rolelist", roleList);
    }

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            Command action = Command.fromPath(request, database);

            if (action instanceof CommandUnknown) {
                response.sendError(404);
                return;
            }

            String view = action.execute(request, response);

            if (view.startsWith(Command.REDIRECT_INDICATOR)) {
                String page = view.substring(Command.REDIRECT_INDICATOR.length());
                response.sendRedirect(page);
                return;
            }

            request.getRequestDispatcher("/WEB-INF/" + view + ".jsp").forward(request, response);
        } catch (UnsupportedEncodingException | UserException ex) {
            request.setAttribute("problem", ex.getMessage());
            Logger.getLogger("web").log(Level.SEVERE, ex.getMessage(), ex);
            request.getRequestDispatcher("/errorpage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "FrontController for application";
    }
}
