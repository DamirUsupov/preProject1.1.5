package DAO;

import groovy.beans.PropertyReader;
import model.User;
import org.hibernate.cfg.Configuration;
import util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class UserDaoFactory implements UserDAO {

    public static Properties properties;

    public static UserDAO getDAO() throws IOException, SQLException {
        properties.load(PropertyReader.class.getClassLoader().getResourceAsStream("app.properties"));
        String key = properties.getProperty("daotype");
        if (key.equals("sql"))
            return UserHibernateDAO.getInstance();

        if (key.equals("hibernate"))
            return UserJdbcDAO.getInstance();


        return null;
    }

    public static Connection getConnection() throws IOException, SQLException {

        return DBHelper.getConnection();

    }

    public static Configuration getConfiguration() {

        return DBHelper.getConfiguration();

    }


    @Override
    public void addUser(User user) throws SQLException {

    }

    @Override
    public void deleteUser(User user) throws SQLException {

    }

    @Override
    public void updateUser(Long id, User user) throws SQLException {

    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return null;
    }

    @Override
    public Long getUserId(User user) throws SQLException {
        return null;
    }

    @Override
    public User getUserById(Long id) throws SQLException {
        return null;
    }
}
