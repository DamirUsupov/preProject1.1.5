package DAO;

import model.User;

import java.sql.SQLException;
import java.util.List;

interface UserDAO {

    void addUser(User user) throws SQLException;

    void deleteUser(User user) throws SQLException;

    void updateUser(Long id, User user) throws SQLException;

    List<User> getAllUsers() throws SQLException;

    Long getUserId(User user) throws SQLException;

    User getUserById(Long id) throws SQLException;
}
