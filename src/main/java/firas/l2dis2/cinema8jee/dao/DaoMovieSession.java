package firas.l2dis2.cinema8jee.dao;

import firas.l2dis2.cinema8jee.Entity.MovieSession;
import firas.l2dis2.cinema8jee.Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class DaoMovieSession {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
        System.out.println("DaoMovieSession.main");
        DaoMovieSession daoMovieSession = new DaoMovieSession();
        DaoMovie daoMovie = new DaoMovie();
        DaoCinemaHall daoCinemaHall = new DaoCinemaHall();
//        daoMovieSession.addMovieSession(new MovieSession(null, new Date(), daoMovie.getMovie(1), daoCinemaHall.getCinemaHall(11)));
//        daoMovieSession.addMovieSession(new MovieSession(null, new Date(), daoMovie.getMovie(2), daoCinemaHall.getCinemaHall(4)));
//        daoMovieSession.addMovieSession(new MovieSession(null, new Date(), daoMovie.getMovie(3), daoCinemaHall.getCinemaHall(3)));
//        ArrayList<MovieSession> ls = (ArrayList<MovieSession>) daoMovieSession.getAllMovieSessions();
//        for (MovieSession movieSession : ls) {
//            System.out.println(movieSession.getSessionId() + " : " + movieSession.getMovie().getMovieName() + " : " + movieSession.getHall().getHallName());
//        }
        ArrayList<MovieSession> ls = (ArrayList<MovieSession>) daoMovieSession.getMovieSessionsByMovieId(3);
        for (MovieSession movieSession : ls) {
            System.out.println(movieSession.getSessionId() + " : " + movieSession.getMovie().getMovieName() + " : " + movieSession.getHall().getHallName() + " : " + movieSession.getSessionDate());
        }
    }

    public void addMovieSession(MovieSession movieSession) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(movieSession);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateMovieSession(MovieSession movieSession) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(movieSession);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteMovieSession(MovieSession movieSession) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(movieSession);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MovieSession getMovieSession(int movieSessionId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(MovieSession.class, movieSessionId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Collection<MovieSession> getAllMovieSessions() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from MovieSession", MovieSession.class).list();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Collection<MovieSession> getMovieSessionsByMovieId(int movieId) {
    try (Session session = sessionFactory.openSession()) {
        return session.createQuery("from MovieSession where movie.id = :movieId", MovieSession.class)
                      .setParameter("movieId", movieId)
                      .list();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

}

