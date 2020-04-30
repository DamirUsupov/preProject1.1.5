package service;

import DAO.UserDAO;
import model.User;
import resources.UserDAOFactory;

import java.io.IOException;
import java.util.List;

public class UserService {
    private static UserService userService;
    UserDAO userDAO = new UserDAOFactory().getInstance().getDAO();

    private UserService() throws IOException {

    }

    public static UserService getInstance() throws IOException {

        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public void updateUser(User user) {

        userDAO.updateUser(user);

    }

    public void addUser(User user) {

        userDAO.addUser(user);

    }

    public List<User> getAllUsers() {

        return userDAO.getAllUsers();

    }

    public void deleteUser(User user) {

        userDAO.deleteUser(user);

    }

    public User getUserById(Long id) {

        return userDAO.getUserById(id);

    }

    public boolean userIsAdmin(String email, String pass) {
        return userDAO.userIsAdmin(email, pass);
    }

    public String getRole(String email, String pass) {
        return userDAO.getRole(email, pass);
    }

    public User getUserByEmailAndPass(String email, String pass) {
        return userDAO.getUserByEmailAndPass(email, pass);
    }

    public boolean userIsExist(String email, String pass) {
        return userDAO.userIsExist(email, pass);
    }

    /*public Long getUserId(User user) throws SQLException {

        return userDAO.getUserId(user);

    }*/

}
