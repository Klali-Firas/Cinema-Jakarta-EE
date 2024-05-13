package firas.l2dis2.cinema8jee.dao;

import firas.l2dis2.cinema8jee.Entity.User;
import firas.l2dis2.cinema8jee.Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;

public class DaoUser {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
        System.out.println("DaoUser.main");
        DaoUser daoUser = new DaoUser();
//        User user = new User(null, "firas", "firasklali123@gmail.com", "aze.1234");
//        daoUser.addUser(user);
    }

    public void addUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User login(String email, String password) {
        try (Session session = sessionFactory.openSession()) {
            User user = session.createQuery("from User where email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();
            if (user != null && BCrypt.checkpw(password, user.getPassword())) {
                return user;
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
