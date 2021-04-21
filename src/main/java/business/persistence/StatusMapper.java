package business.persistence;

import business.entities.Status;
import business.entities.Topping;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusMapper {

    private Database database;

    public StatusMapper(Database database) {
        this.database = database;
    }

    public List<Status> getAllStatus() throws UserException {
        List<Status> statusList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM `status`";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    int statusId = resultSet.getInt("status_id");
                    String name = resultSet.getString("name");
                    statusList.add(new Status(statusId, name));
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
        return statusList;
    }
}
