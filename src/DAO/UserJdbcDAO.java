package DAO;

import model.User;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO {

    private static UserJdbcDAO userJdbcDAO;
    private        Connection  connection;

    public UserJdbcDAO(Connection connection) {
        this.connection = connection;
    }

    public static UserDAO getInstanceUserDAO() {
        if (userJdbcDAO == null) {
            userJdbcDAO = new UserJdbcDAO(DBHelper.getConnection());
        }
        return userJdbcDAO;
    }

    @Override
    public void addUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO user(email, name, pass) VALUES (?, ?, ?)");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getName());
            statement.setString(3, user.getPass());
            statement.execute();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM user WHERE email = ? AND name = ? AND pass = ?");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getName());
            statement.setString(3, user.getPass());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE user SET email = ?, name = ?, pass = ? WHERE id = ?");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getName());
            statement.setString(3, user.getPass());
            statement.setLong(4, user.getId());
            statement.execute();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> usersLst = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user");
            ResultSet rs = preparedStatement.executeQuery();
            usersLst = new ArrayList<>();

            while (rs.next()) {
                usersLst.add(new User(
                        rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("name"),
                        rs.getString("pass"),
                        rs.getString("role")));
            }
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersLst;

    }

    @Override
    public User getUserByEmailAndPass(String email, String Pass) {
        return null;
    }

    /*@Override
    public Long getUserId(User user) throws SQLException {

        String query = "SELECT id FROM user WHERE email = ? AND name = ? AND pass = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getEmail());
        statement.setString(2, user.getName());
        statement.setString(3, user.getPass());
        ResultSet result = statement.executeQuery();
        result.next();
        Long id = result.getLong(1);
        result.close();
        statement.close();
        return id;
    }*/

    @Override
    public User getUserById(Long id) {

        User user = null;
        try {
            String query = "SELECT * FROM user WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            user = new User(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean userIsAdmin(String email, String pass) {

        boolean res = false;
        try {
            String query = "SELECT id FROM user WHERE email = ? AND pass = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, pass);
            ResultSet result = statement.executeQuery();
            result.next();
            String role = result.getString(5);
            result.close();
            statement.close();
            if (role.equals("admin")) {
                res = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public String getRole(String email, String pass) {
        String res = "USER";
        try {
            String query = "SELECT id FROM user WHERE email = ? AND pass = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, pass);
            ResultSet result = statement.executeQuery();
            result.next();
            String role = result.getString(5);
            result.close();
            statement.close();
            if (role.equals("ADMIN")) {
                res = "ADMIN";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean userIsExist(String email, String pass) {
        return false;
    }


}
