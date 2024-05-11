package firas.l2dis2.cinema8jee.dao;

import firas.l2dis2.cinema8jee.Entity.Movie;
import firas.l2dis2.cinema8jee.Entity.MovieCategory;
import firas.l2dis2.cinema8jee.Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class DaoMovie {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
        System.out.println("DaoMovie.main");
        DaoMovie daoMovie = new DaoMovie();
        DaoMovieCategory daoMovieCategory = new DaoMovieCategory();
//        daoMovie.addMovie(new Movie(null, "Hibernate for Begginers",new Date(),daoMovieCategory.getMovieCategory(1)));
//        daoMovie.addMovie(new Movie(null, "Hibernate for Experts",new Date(),daoMovieCategory.getMovieCategory(2)));
//        daoMovie.addMovie(new Movie(null, "Hibernate for Masters",new Date(),daoMovieCategory.getMovieCategory(3)));
//        daoMovie.addMovie(new Movie(null, "Hibernate for Dummies",new Date(),daoMovieCategory.getMovieCategory(4)));
        Session session = HibernateUtil.getSessionFactory().openSession();

        LinkedList<Movie> lst = new LinkedList<>(daoMovie.getAllMovies());
        for (Movie movie : lst) {
            System.out.println(movie.getMovieName());
        }
        session.close();

    }

    public void addMovie(Movie movie) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(movie);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateMovie(Movie movie) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(movie);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteMovie(Movie movie) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(movie);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Movie getMovie(int movieId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Movie.class, movieId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Collection<Movie> getAllMovies() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Movie", Movie.class).list();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Movie> findByMovieName(String movieName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Movie> query = session.createQuery("FROM Movie WHERE movieName = :movieName", Movie.class);
            query.setParameter("movieName", movieName);
            return query.getResultList();
        }
    }

    public List<Movie> findByCategory(MovieCategory category) {
        try (Session session = sessionFactory.openSession()) {
            Query<Movie> query = session.createQuery("FROM Movie WHERE category = :category", Movie.class);
            query.setParameter("category", category);
            return query.getResultList();
        }
    }

    public List<Movie> findByMovieNameAndCategory(String movieName, MovieCategory category) {
        try (Session session = sessionFactory.openSession()) {
            Query<Movie> query = session.createQuery("FROM Movie WHERE movieName = :movieName AND category = :category", Movie.class);
            query.setParameter("movieName", movieName);
            query.setParameter("category", category);
            return query.getResultList();
        }
    }

}
