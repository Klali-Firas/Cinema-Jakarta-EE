package firas.l2dis2.cinema8jee.Utility;

import firas.l2dis2.cinema8jee.config.HibernateConfig;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = HibernateConfig.getConfiguration();
            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
        } catch (Exception e) {
            throw new RuntimeException("Error initializing Hibernate", e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void main(String[] args) {
        System.out.println("HibernateUtil.main");
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    }
}
