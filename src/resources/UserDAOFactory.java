package resources;


import DAO.UserDAO;
import DAO.UserHibernateDAO;
import DAO.UserJdbcDAO;
import util.PropertyReader;

import java.io.IOException;

public class UserDAOFactory {
    private Object userDAOFactory;

    public UserDAOFactory() {
    }

    public UserDAOFactory getInstance() {
        if (userDAOFactory == null) {
            userDAOFactory = new UserDAOFactory();
        }
        return (UserDAOFactory) userDAOFactory;
    }

    public UserDAO getDAO() throws IOException {
        String key = PropertyReader.getValueByKey("daoType");
        if (key.equals("hibernate")) {
            return UserHibernateDAO.getInstanceUserDAO();
        } else if (key.equals("sql")) {
            return UserJdbcDAO.getInstanceUserDAO();
        }

        return null;
    }

}
