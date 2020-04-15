package service;

import DAO.UserDAO;
import model.User;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.util.List;

public class UserService {
    private static UserService userService;

    private SessionFactory sessionFactory;

    private UserService() {

    }

    private UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService(DBHelper.getSessionFactory());
        }
        return userService;
    }

    public void updateUser(Long id, String email, String name, String pass) {
        new UserDAO(sessionFactory.openSession()).updateUser(id, email, name, pass);
    }

    public void addUser(User user) {
        new UserDAO(sessionFactory.openSession()).addUser(user);
    }

    public List<User> getAllUsers() {
        return new UserDAO(sessionFactory.openSession()).getAllUsers();
    }

    public void deleteUser(User user) {
        new UserDAO(sessionFactory.openSession()).deleteUser(user);
    }


    public void changeUser(User oldUser, User newUser) {

        new UserDAO(sessionFactory.openSession()).changeUser(oldUser, newUser);

    }

    public User getUserById(Long id) {
        return new UserDAO(sessionFactory.openSession()).getUserById(id);
    }

    public Long getUserId(String email, String name, String pass) {
        return new UserDAO(sessionFactory.openSession()).getUserId(email, name, pass);
    }
}
