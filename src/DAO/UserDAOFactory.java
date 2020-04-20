package DAO;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserDAOFactory {

    String key = getKey();

    public UserDAOFactory() throws IOException {
    }

    public static String getKey() throws IOException {

        FileInputStream fis;
        Properties properties = new Properties();
        fis = new FileInputStream(new File("C:\\Users\\usupov\\Desktop\\preProj1\\src\\app.properties"));
        properties.load(fis);
        return properties.getProperty("daoType");
    }

    public UserDAO getDAO(){

        if (key.equals("hibernate")) {
            return UserHibernateDAO.getInstanceUserDAO();
        } else if (key.equals("sql")) {
            return UserJdbcDAO.getInstanceUserDAO();
        }

        return null;
    }

}
