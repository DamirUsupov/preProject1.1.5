package service;

import DAO.UserDAO;
import DAO.UserDAOFactory;
import model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static UserService userService;
    UserDAO userDAO = new UserDAOFactory().getDAO();

    private UserService() throws IOException {

    }

    public static UserService getInstance() throws IOException {

        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public void updateUser(Long id, User user) throws SQLException {

        userDAO.updateUser(id, user);

    }

    public void addUser(User user) throws SQLException {

        userDAO.addUser(user);

    }

    public List<User> getAllUsers() throws SQLException {

        return userDAO.getAllUsers();

    }

    public void deleteUser(User user) throws SQLException {

        userDAO.deleteUser(user);

    }

    public User getUserById(Long id) throws SQLException {

        return userDAO.getUserById(id);

    }

    /*public Long getUserId(User user) throws SQLException {

        return userDAO.getUserId(user);

    }*/
}
