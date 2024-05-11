package firas.l2dis2.cinema8jee.Service;

import firas.l2dis2.cinema8jee.Entity.MovieSession;
import firas.l2dis2.cinema8jee.dao.DaoMovieSession;

import java.util.Collection;

public class MovieSessionService {
    DaoMovieSession daoMovieSession = new DaoMovieSession();

    public void createMovieSession(MovieSession movieSession) {
        daoMovieSession.addMovieSession(movieSession);
    }

    public void modifyMovieSession(MovieSession movieSession) {
        daoMovieSession.updateMovieSession(movieSession);
    }

    public void removeMovieSession(MovieSession movieSession) {
        daoMovieSession.deleteMovieSession(movieSession);
    }

    public MovieSession getMovieSession(int movieSessionId) {
        return daoMovieSession.getMovieSession(movieSessionId);
    }

    public Collection<MovieSession> getAllMovieSessions() {
        return daoMovieSession.getAllMovieSessions();
    }

    public Collection<MovieSession> getMovieSessionsByMovieId(int movieId) {
        return daoMovieSession.getMovieSessionsByMovieId(movieId);
    }
}
