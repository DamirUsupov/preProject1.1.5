package DAO;

import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO {
    private Session session;


    public UserDAO(Session session) {
        this.session = session;
    }


    public void addUser(User user) {

        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();

    }

    public void deleteUser(User user) {

        Transaction tx = session.beginTransaction();
        session.delete(user);
        tx.commit();
        session.close();

    }

    public void changeUser(User oldUser, User newUser) {

        deleteUser(oldUser);
        addUser(newUser);

    }

    public void updateUser(Long id, String email, String name, String pass) {
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("update User set email = :emailPrm, " +
                                                                "name = :namePrm, " +
                                                                "pass = :passPrm where id = :idPrm").
                setParameter("idPrm", id).
                setParameter("emailPrm", email).
                setParameter("namePrm", name).
                setParameter("passPrm", pass);
        q.executeUpdate();
        tx.commit();
        session.close();
    }


    public List<User> getAllUsers() {
        List<User> users;
        Query q = session.createQuery("FROM User");
        users = q.list();
        session.close();
        return users;
    }

    public Long getUserId(String email, String name, String pass) {
        Query q = session.createQuery("from User WHERE email = :emailPrm and name = :namePrm and pass = :passPrm")
                .setParameter("emailPrm", email)
                .setParameter("namePrm", name)
                .setParameter("passPrm", pass);
        User user = (User) q.uniqueResult();
        return user.getId();

    }

    public User getUserById(Long id) {
        Query q = session.createQuery("from User WHERE id = :idPrm")
                .setParameter("idPrm", id);
        User user = (User) q.uniqueResult();
        return user;
    }
}
