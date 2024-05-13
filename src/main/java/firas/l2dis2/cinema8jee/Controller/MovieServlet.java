//Icon : src/main/resources/java-servlet.png

package firas.l2dis2.cinema8jee.Controller;

import firas.l2dis2.cinema8jee.Entity.Movie;
import firas.l2dis2.cinema8jee.Entity.MovieCategory;
import firas.l2dis2.cinema8jee.Entity.MovieSession;
import firas.l2dis2.cinema8jee.Service.MovieCategoryService;
import firas.l2dis2.cinema8jee.Service.MovieService;
import firas.l2dis2.cinema8jee.Service.MovieSessionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@WebServlet(name = "MovieServlet", value = {"/Movies", "/addMovie", "/movieDetails", "/editMovie", "/deleteMovie"})
public class MovieServlet extends HttpServlet {
    MovieService movieService;
    MovieCategoryService movieCategoryService;
    MovieSessionService movieSessionService;

    public void init() {
        this.movieService = new MovieService();
        this.movieCategoryService = new MovieCategoryService();
        this.movieSessionService = new MovieSessionService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session.getAttribute("email") == null) {
            response.sendRedirect("/");
            return;
        }
        String path = request.getServletPath();
//        if (path.equals("/Movies")) {
//            System.out.println("here");
//            getAllMovies(request, response);
//        }
        if (path.startsWith("/addMovie")) {
            ArrayList<MovieCategory> categories = new ArrayList<MovieCategory>(movieCategoryService.getAllMovieCategories());
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/addMovie.jsp").forward(request, response);
        } else if (path.startsWith("/movieDetails")) {
            String movieId = request.getParameter("movieId");
            Movie movie = movieService.getMovie(Integer.parseInt(movieId));
            Collection<MovieSession> sessions = movieSessionService.getMovieSessionsByMovieId(movie.getMovieId());
            request.setAttribute("sessions", sessions);
            request.setAttribute("movie", movie);
            request.getRequestDispatcher("/movieDetails.jsp").forward(request, response);
        } else if (path.startsWith("/editMovie")) {
            String movieId = request.getParameter("movieId");
            Movie movie = movieService.getMovie(Integer.parseInt(movieId));
            request.setAttribute("movie", movie);
            ArrayList<MovieCategory> categories = new ArrayList<MovieCategory>(movieCategoryService.getAllMovieCategories());
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/editMovie.jsp").forward(request, response);
        } else if (path.startsWith("/deleteMovie")) {
            String movieId = request.getParameter("movieId");
            movieService.removeMovie(movieService.getMovie(Integer.parseInt(movieId)));
            response.sendRedirect("Movies");
        } else if (path.startsWith("/Movies")) {
            getFilteredMovies(request, response);
        }
    }

    public void getFilteredMovies(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String movieName = request.getParameter("movieName");
        String categoryId = request.getParameter("categoryId");
        Collection categories = movieCategoryService.getAllMovieCategories();
        request.setAttribute("categories", categories);
        Collection movies;
        System.out.println(movieName);
        System.out.println(categoryId);
        if (movieName != null && !movieName.isEmpty() && categoryId != null) {
            movies = movieService.getMoviesByCategoryAndName(movieCategoryService.getMovieCategory(Integer.parseInt(categoryId)), movieName);
        } else if (movieName != null && !movieName.isEmpty()) {
            movies = movieService.getMoviesByName(movieName);
        } else if (categoryId != null) {
            movies = movieService.getMoviesByCategory(movieCategoryService.getMovieCategory(Integer.parseInt(categoryId)));
        } else {
            movies = movieService.getAllMovies();
        }
        request.setAttribute("movies", movies);
        request.getRequestDispatcher("/allMovies.jsp").forward(request, response);
    }

//    public void getAllMovies(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        Collection movies = movieService.getAllMovies();
//        Collection categories = movieCategoryService.getAllMovieCategories();
//        request.setAttribute("categories", categories);
//        request.setAttribute("movies", movies);
//        request.getRequestDispatcher("/allMovies.jsp").forward(request, response);
//    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("email") == null) {
            response.sendRedirect("/");
            return;
        }
        String path = request.getServletPath();

        if (path.equals("/addMovie")) {
            addMovie(request, response);
        } else if (path.equals("/editMovie")) {
            editMovie(request, response);
        }
    }

    public void editMovie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String movieId = request.getParameter("movieId");
            String movieName = request.getParameter("movieName");
            String cover = request.getParameter("cover");
            String releaseDate = request.getParameter("releaseDate");
            String categoryId = request.getParameter("categoryId");
            MovieCategory category = movieCategoryService.getMovieCategory(Integer.parseInt(categoryId));
            System.out.println(releaseDate);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date rDate = formatter.parse(releaseDate);

            Movie movie = new Movie(Integer.parseInt(movieId), movieName, cover, rDate, category);

            movieService.modifyMovie(movie);
            response.sendRedirect("Movies");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void addMovie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String movieName = request.getParameter("movieName");
            String cover = request.getParameter("cover");
            String releaseDate = request.getParameter("releaseDate");
            String categoryId = request.getParameter("categoryId");
            MovieCategory category = movieCategoryService.getMovieCategory(Integer.parseInt(categoryId));
            System.out.println(releaseDate);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date rDate = formatter.parse(releaseDate);

            Movie movie = new Movie(null, movieName, cover, rDate, category);

            movieService.createMovie(movie);
            response.sendRedirect("Movies");
        } catch (Exception e) {
            e.printStackTrace();
//            response.sendRedirect("addMovie");

        }
    }

    public void destroy() {
    }
}
