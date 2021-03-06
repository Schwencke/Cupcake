package business.persistence;

import business.exceptions.UserException;
import business.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    private Database database;

    public UserMapper(Database database) {
        this.database = database;
    }

    public void createUser(User user) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO `user` (firstname, lastname, phone_no, email, password) VALUES (?, ?, ?, ?, ?)";

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
                user.setUserId(userId);
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }

            String sql2 = "SELECT `role_id`, `balance` FROM user WHERE `user_id`= ?";
            try (PreparedStatement ps2 = connection.prepareStatement(sql2)) {
                ps2.setInt(1, user.getUserId());
                ResultSet rs2 = ps2.executeQuery();
                while (rs2.next()) {
                    int roleId = rs2.getInt("role_id");
                    int balance = rs2.getInt("balance");
                    user.setRoleId(roleId);
                    user.setBalance(balance);
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public User login(String email, String password) throws UserException, SQLException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM `user` WHERE `email` = ? AND `password` = ?";
            User user = new User();

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
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
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }

            String sql2 = "SELECT `name` FROM `role` WHERE `role_id` = ?";
            try (PreparedStatement ps2 = connection.prepareStatement(sql2)) {
                ps2.setInt(1, user.getRoleId());
                ResultSet rs2 = ps2.executeQuery();
                if (rs2.next()) {
                    String name = rs2.getString("name");
                    user.setRole(name);
                    return user;
                } else {
                    throw new UserException("Could not validate user");
                }
            } catch (SQLException ex) {
                throw new UserException("Connection to database could not be established");
            }
        }
    }

    public List<User> getAllUsers() throws UserException {
        List<User> userList = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM `user`";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int userId = rs.getInt("user_id");
                    int roleId = rs.getInt("role_id");
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    String phoneNo = rs.getString("phone_no");
                    int balance = rs.getInt("balance");
                    String email = rs.getString("email");
                    userList.add(new User(userId, roleId, firstname, lastname, phoneNo, balance, email));
                }
                return userList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public int getBalance(int userId) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT `balance` FROM `user` WHERE `user_id` = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, userId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("balance");
                }
                return 0;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public int updateBalance(int userId, int balance) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "UPDATE `user` SET `balance` = ? WHERE `user_id` = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, balance);
                ps.setInt(2, userId);
                return ps.executeUpdate();
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }
}
