package DAO;

import model.User;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO {
    private Connection connection;
    private Session    session;


    public UserJdbcDAO(Session session) {
        this.session = session;
    }

    @Override
    public void addUser(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into user(email, name, pass) values (?, ?, ?)");
        statement.setString(1, user.getEmail());
        statement.setString(2, user.getName());
        statement.setString(3, user.getPass());
        statement.execute();
        statement.close();

    }

    @Override
    public void deleteUser(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("delete from user where email = ?, name = ?, pass = ?");
        statement.setString(1, user.getEmail());
        statement.setString(2, user.getName());
        statement.setString(3, user.getPass());
        statement.execute();
        statement.close();

    }

    @Override
    public void updateUser(Long id, User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("update from user set email = ?, name = ?, pass = ? where id = ?");
        statement.setString(1, user.getEmail());
        statement.setString(2, user.getName());
        statement.setString(3, user.getPass());
        statement.setLong(4, id);
        statement.execute();
        statement.close();
    }

    @Override
    public List<User> getAllUsers() throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user");
        ResultSet rs = preparedStatement.executeQuery();
        List<User> usersLst = new ArrayList<>();

        while (rs.next()) {
            usersLst.add(new User(rs.getString("email"),
                    rs.getString("name"),
                    rs.getString("pass")));
        }
        preparedStatement.close();

        return usersLst;

    }

    @Override
    public Long getUserId(User user) throws SQLException {

        String query = "SELECT id FROM user WHERE email = ?, name = ?, pass = ?";
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
    }

    @Override
    public User getUserById(Long id) throws SQLException {
        String query = "select * from user where id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();
        rs.next();
        return new User(rs.getString(2), rs.getString(3), rs.getString(4));

    }


}
