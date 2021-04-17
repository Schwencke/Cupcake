package business.persistence;

import business.exceptions.UserException;
import business.entities.User;

import java.sql.*;

public class UserMapper {

    private Database database;

    public UserMapper(Database database) {
        this.database = database;
    }

    public void createUser(User user) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO user (firstname, lastname, phone_no, email, password) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, user.getFirstname());
                ps.setString(2, user.getLastname());
                ps.setString(3, user.getPhoneNo());
                ps.setString(4, user.getEmail());
                ps.setString(5, user.getPassword());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int userId = ids.getInt(1);
                int roleId = ids.getInt(2);
                user.setUserId(userId);
                user.setRoleId(roleId);
                user.setBalance(0);
            } catch (SQLException ex) {
                throw new UserException("Emailen findes allerede");
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public User login(String email, String password) throws UserException {

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM user WHERE email=? AND password=?";


            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                User user = new User();
                while (rs.next()) {
                    int userId = rs.getInt("user_id");
                    int roleId = rs.getInt("role_id");
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    String phoneNo = rs.getString("phone_no");
                    int balance = rs.getInt("balance");
                    user.setUserId(userId);
                    user.setRoleId(roleId);
                    user.setFirstname(firstname);
                    user.setLastname(lastname);
                    user.setPhoneNo(phoneNo);
                    user.setBalance(balance);
                    user.setEmail(email);
                    user.setPassword(password);
                }
                String sql2 = "SELECT name FROM role WHERE role_id=?";
                try (PreparedStatement ps2 = connection.prepareStatement(sql2)) {
                    ps2.setInt(1, user.getRoleId());
                    ResultSet rs2 = ps2.executeQuery();
                    while (rs2.next()) {
                        String name = rs2.getString("name");
                        user.setRole(name);
                    }
                    return user;

                } catch (SQLException ex) {
                    throw new UserException(ex.getMessage());
                }
            } catch (SQLException ex) {
                throw new UserException("Connection to database could not be established");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
