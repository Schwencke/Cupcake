package business.services;

import business.entities.User;
import business.persistence.Database;
import business.persistence.UserMapper;
import business.exceptions.UserException;

import java.sql.SQLException;
import java.util.List;

public class UserFacade {
    UserMapper userMapper;

    public UserFacade(Database database) {
        userMapper = new UserMapper(database);
    }

    public User login(String email, String password) throws UserException, SQLException {
        return userMapper.login(email, password);
    }

    public User createUser(String firstname, String lastname, String phoneNo, String email, String password) throws UserException {
        User user = new User(firstname, lastname, phoneNo, email, password);
        userMapper.createUser(user);
        return user;
    }
    public List<User> getAllUsers() throws UserException {
        return userMapper.getAllUsers();
    }

    public int getBalance(int userId) throws UserException {
        return userMapper.getBalance(userId);
    }

    public void updateBalance(int userId, int balance) throws UserException {
        userMapper.updateBalance(userId, balance);
    }
}
