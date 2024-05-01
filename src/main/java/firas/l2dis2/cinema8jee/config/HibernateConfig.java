package firas.l2dis2.cinema8jee.config;

import firas.l2dis2.cinema8jee.Entity.CinemaHall;
import firas.l2dis2.cinema8jee.Entity.Movie;
import firas.l2dis2.cinema8jee.Entity.MovieCategory;
import firas.l2dis2.cinema8jee.Entity.MovieSession;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
    public static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(CinemaHall.class);
        configuration.addAnnotatedClass(Movie.class);
        configuration.addAnnotatedClass(MovieSession.class);
        configuration.addAnnotatedClass(MovieCategory.class);

//        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/cinema");
//        configuration.setProperty("hibernate.connection.username", "postgres");
//        configuration.setProperty("hibernate.connection.password", "aze.1234");
//        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
//        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//        configuration.setProperty("hibernate.show_sql", "true");

        // Other Hibernate properties (e.g., dialect, show_sql, etc.)
        return configuration;
    }


}
