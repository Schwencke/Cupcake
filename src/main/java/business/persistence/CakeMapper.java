package business.persistence;

import business.entities.Bottom;
import business.entities.Topping;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CakeMapper {

    private Database database;

    public CakeMapper(Database database) {
        this.database = database;
    }

    public List<Topping> getAllToppings() throws UserException {
        List<Topping> toppings = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM topping";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()){
                    int toppingId = resultSet.getInt("topping_id");
                    String flavor = resultSet.getString("flavor");
                    int price = resultSet.getInt("price");

                    toppings.add(new Topping(toppingId,flavor,price));

                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
        return toppings;
    }


    public List<Bottom> getAllBottoms() throws UserException {
        List<Bottom> bottoms = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM bottom";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()){
                    int bottomId = resultSet.getInt("bottom_id");
                    String flavor = resultSet.getString("flavor");
                    int price = resultSet.getInt("price");

                    bottoms.add(new Bottom(bottomId,flavor,price));

                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
        return bottoms;
    }

}
