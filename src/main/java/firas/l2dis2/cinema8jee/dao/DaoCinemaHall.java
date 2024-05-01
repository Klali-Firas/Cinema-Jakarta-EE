package firas.l2dis2.cinema8jee.dao;

import firas.l2dis2.cinema8jee.Entity.CinemaHall;
import firas.l2dis2.cinema8jee.Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DaoCinemaHall {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    public CinemaHall getCinemaHall(int hallId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(CinemaHall.class, hallId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<CinemaHall> getAllCinemaHalls() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from CinemaHall", CinemaHall.class).list();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addCinemaHall(CinemaHall cinemaHall) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(cinemaHall);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCinemaHall(CinemaHall cinemaHall) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(cinemaHall);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCinemaHall(CinemaHall cinemaHall) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(cinemaHall);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //    public static void main(String[] args) {
//        DaoCinemaHall daoCinemaHall = new DaoCinemaHall();
//        List<CinemaHall> halls = daoCinemaHall.getAllCinemaHalls();
//        for (CinemaHall hall : halls) {
//            System.out.println(hall.getHallName());
//        }
//    }

}
