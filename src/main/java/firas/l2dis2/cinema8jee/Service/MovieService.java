package firas.l2dis2.cinema8jee.Service;

import firas.l2dis2.cinema8jee.Entity.Movie;
import firas.l2dis2.cinema8jee.Entity.MovieCategory;
import firas.l2dis2.cinema8jee.dao.DaoMovie;

import java.util.Collection;
import java.util.List;

public class MovieService {
    DaoMovie daoMovie = new DaoMovie();

    public void createMovie(Movie movie) {
        daoMovie.addMovie(movie);
    }

    public void modifyMovie(Movie movie) {
        daoMovie.updateMovie(movie);
    }

    public void removeMovie(Movie movie) {
        daoMovie.deleteMovie(movie);
    }

    public Movie getMovie(int movieId) {
        return daoMovie.getMovie(movieId);
    }

    public Collection<Movie> getAllMovies() {
        return daoMovie.getAllMovies();
    }

    public List<Movie> getMoviesByCategory(MovieCategory category) {
        return daoMovie.findByCategory(category);
    }

    public List<Movie> getMoviesByName(String movieName) {
        return daoMovie.findByMovieName(movieName);
    }

    public List<Movie> getMoviesByCategoryAndName(MovieCategory category, String movieName) {
        return daoMovie.findByMovieNameAndCategory(movieName,category );
    }

}
