package firas.l2dis2.cinema8jee.dao;

import firas.l2dis2.cinema8jee.Entity.MovieCategory;
import firas.l2dis2.cinema8jee.Utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Collection;

public class DaoMovieCategory {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
        DaoMovieCategory daoMovieCategory = new DaoMovieCategory();
//        daoMovieCategory.addMovieCategory(new MovieCategory(null, "Action"));
//        daoMovieCategory.addMovieCategory(new MovieCategory(null, "Comedy"));
//        daoMovieCategory.addMovieCategory(new MovieCategory(null, "Drama"));
        ArrayList<MovieCategory> mc = new ArrayList<>(daoMovieCategory.getAllMovieCategories());
        for (MovieCategory movieCategory : mc) {
            System.out.println(movieCategory.getLabel());
        }
    }

    public void addMovieCategory(MovieCategory movieCategory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(movieCategory);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateMovieCategory(MovieCategory movieCategory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(movieCategory);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteMovieCategory(MovieCategory movieCategory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(movieCategory);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MovieCategory getMovieCategory(int movieCategoryId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(MovieCategory.class, movieCategoryId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Collection<MovieCategory> getAllMovieCategories() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from MovieCategory", MovieCategory.class).list();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
