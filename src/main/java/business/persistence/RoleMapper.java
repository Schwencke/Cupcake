package business.persistence;

import business.entities.Role;
import business.entities.Status;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleMapper {

    private Database database;

    public RoleMapper(Database database) {
        this.database = database;
    }

    public List<Role> getAllRoles() throws UserException {
        List<Role> roleList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM `role`";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    int roleId = resultSet.getInt("role_id");
                    String name = resultSet.getString("name");
                    roleList.add(new Role(roleId, name));
                }
                return roleList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }
}
