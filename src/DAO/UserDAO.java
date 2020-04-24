package DAO;

import model.User;

import java.util.List;

public interface UserDAO {


    void addUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUserByEmailAndPass(String email, String Pass);

    User getUserById(Long id);

    boolean userIsAdmin(String email, String pass);

    String getRole(String email, String pass);

    boolean userIsExist(String email, String pass);
}
