package business.persistence;

import business.entities.User;
import business.exceptions.UserException;
import business.services.UserFacade;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.sql.Statement;
import static org.junit.jupiter.api.Assertions.*;

public class UserMapperTest {

    private final static String USER = "root";
    private final static String PASSWORD = "1234";
    private final static String URL = "jdbc:mysql://localhost:3306/cupcake_test?serverTimezone=CET";

    private static Database database;
    private static UserFacade userFacade;

    @BeforeAll
    public static void setUpClass() {
        try {
            database = new Database(USER, PASSWORD, URL);
            userFacade = new UserFacade(database);
        } catch (ClassNotFoundException e) {   // kan ikke finde driveren i database klassen
            fail("Database connection failed. Missing jdbc driver");
        }
    }

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void login () throws UserException, SQLException {
        User user = userFacade.login("thomasovergaard@hotmail.com", "1");
        assertNotNull(user);
        assertEquals("thomasovergaard@hotmail.com", user.getEmail());
    }

    @Test
    public void loginWrongPass (){
        assertThrows(UserException.class, () ->
        {User user = userFacade.login( "thomasovergaard@hotmail.com", "asfasf" ); });
    }

    @Test
    public User createUser(String firstname, String lastname, String phoneNo, String email, String password) throws UserException, SQLException {
        User user = userFacade.createUser("Ib","Ibsen","99887766","Ib@ibber.dk", "1234");
        assertNotNull(user);
        userFacade.login("Ib@ibber.dk", "1234");
        assertEquals("99887766", user.getPhoneNo());
        return user;
    }
}