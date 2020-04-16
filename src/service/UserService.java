package service;

import DAO.UserHibernateDAO;
import model.User;

import java.util.List;

public class UserService {
    private static UserService userService;

    private UserService() {

    }

    public static UserService getInstance() {

        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

   /* public UsersDAO usersDAO() {
        try {
            if (s.equals("hib")) {
                userDAO = new UserHibernateDAO(sessionFactory.openSession());
            } else {
                userDAO = new UserJdbcDAO(sessionFactory.openSession());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (UsersDAO) userDAO;
    }*/

    public void updateUser(Long id, User user) {

        UserHibernateDAO.getInstance().updateUser(id, user);

    }

    public void addUser(User user) {

        UserHibernateDAO.getInstance().addUser(user);

    }

    public List<User> getAllUsers() {

        return UserHibernateDAO.getInstance().getAllUsers();

    }

    public void deleteUser(User user) {

        UserHibernateDAO.getInstance().deleteUser(user);

    }

    public User getUserById(Long id) {

        return UserHibernateDAO.getInstance().getUserById(id);

    }

    public Long getUserId(User user) {

        return UserHibernateDAO.getInstance().getUserId(user);

    }
}
