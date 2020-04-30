package DAO;

import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;

import java.util.List;

public class UserHibernateDAO implements UserDAO {

    public static  UserHibernateDAO userHibernateDAO;
    private static Session          session;

    public UserHibernateDAO(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }

    public static UserDAO getInstanceUserDAO() {

        if (userHibernateDAO == null) {
            userHibernateDAO = new UserHibernateDAO(DBHelper.getSessionFactory());
        }
        return userHibernateDAO;

    }

    @Override
    public void addUser(User user) {

        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();

    }

    @Override
    public void deleteUser(User user) {

        Transaction tx = session.beginTransaction();
        session.delete(user);
        tx.commit();

    }

    @Override
    public void updateUser(User user) {

        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("update User set email = :emailPrm, " +
                "name = :namePrm, " +
                "pass = :passPrm, " +
                "role = :rolePrm " +
                "where id = :idPrm").
                setParameter("idPrm", user.getId()).
                setParameter("emailPrm", user.getEmail()).
                setParameter("namePrm", user.getName()).
                setParameter("passPrm", user.getPass()).
                setParameter("rolePrm", user.getRole());
        q.executeUpdate();
        tx.commit();

    }

    @Override
    public List<User> getAllUsers() {
        session.close();
        new UserHibernateDAO(DBHelper.getSessionFactory());
        Query q = session.createQuery("FROM User");
        return q.list();
    }

    @Override
    public User getUserByEmailAndPass(String email, String pass) {
        Query q = session.createQuery("FROM User WHERE email = :emailPrm and pass = :passPrm")
                .setParameter("emailPrm", email)
                .setParameter("passPrm", pass);
        return (User) q.uniqueResult();
    }

    /*@Override
    public Long getUserId(User user) {

        Query q = session.createQuery("from User WHERE email = :emailPrm and name = :namePrm and pass = :passPrm").
                setParameter("emailPrm", user.getEmail()).
                setParameter("namePrm", user.getName()).
                setParameter("passPrm", user.getPass());
        User userWithId = (User) q.uniqueResult();
        return userWithId.getId();

    }*/

    @Override
    public User getUserById(Long id) {

        Query q = session.createQuery("from User WHERE id = :idPrm")
                .setParameter("idPrm", id);

        return (User) q.uniqueResult();

    }

    @Override
    public boolean userIsAdmin(String email, String pass) {
        Query q = session.createQuery("from User WHERE email = :emailPrm and pass = :passPrm").
                setParameter("emailPrm", email).
                setParameter("passPrm", pass);
        User userWithRole = (User) q.uniqueResult();

        return userWithRole.getRole().equals("ADMIN");
    }

    @Override
    public String getRole(String email, String pass) {

        Query q = session.createQuery("from User WHERE email = :emailPrm and pass = :passPrm").
                setParameter("emailPrm", email).

                setParameter("passPrm", pass);
        User userWithRole = (User) q.uniqueResult();

        return userWithRole.getRole();

    }

    @Override
    public boolean userIsExist(String email, String pass) {
        Query q = session.createQuery("from User WHERE email = :emailPrm and pass = :passPrm").
                setParameter("emailPrm", email).
                setParameter("passPrm", pass);
        User user = (User) q.uniqueResult();

        return user != null;
    }


}
