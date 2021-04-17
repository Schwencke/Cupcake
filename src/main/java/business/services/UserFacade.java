package business.services;

import business.entities.User;
import business.persistence.Database;
import business.persistence.UserMapper;
import business.exceptions.UserException;

public class UserFacade
{
    UserMapper userMapper;

    public UserFacade(Database database)
    {
        userMapper = new UserMapper(database);
    }

    public User login(String email, String password) throws UserException
    {
        return userMapper.login(email, password);
    }

    public User createUser(String firstname, String lastname, String phoneNo, String email, String password) throws UserException
    {
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setPhoneNo(phoneNo);
        user.setEmail(email);
        user.setPassword(password);
        userMapper.createUser(user);
        return user;
    }

}
