//Icon : src/main/resources/java-servlet.png

package firas.l2dis2.cinema8jee.Controller;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import firas.l2dis2.cinema8jee.Entity.CinemaHall;
import firas.l2dis2.cinema8jee.Entity.Movie;
import firas.l2dis2.cinema8jee.Entity.MovieSession;
import firas.l2dis2.cinema8jee.Service.CinemaHallService;
import firas.l2dis2.cinema8jee.Service.MovieService;
import firas.l2dis2.cinema8jee.Service.MovieSessionService;
import firas.l2dis2.cinema8jee.dao.DaoCinemaHall;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "MovieSessionController", value = {"/deleteMovieSession", "/addMovieSession"})
public class MovieSessionController extends HttpServlet {
    private MovieSessionService movieSessionService;
    private MovieService movieService;
    private CinemaHallService cinemaHallService;

    public void init() {
        this.movieSessionService = new MovieSessionService();
        this.movieService = new MovieService();
        this.cinemaHallService = new CinemaHallService(new DaoCinemaHall());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getServletPath();
        if (path.startsWith("/addMovieSession")) {
            String movieId = request.getParameter("movieId");
            if(movieId != null && !movieId.isEmpty()){
                request.setAttribute("movieId", Integer.parseInt((movieId)));

            }
            ArrayList<Movie> movies = new ArrayList<Movie>(movieService.getAllMovies());
            request.setAttribute("movies", movies);
            ArrayList<CinemaHall> cinemaHalls = new ArrayList<CinemaHall>(cinemaHallService.getAllCinemaHalls());
            request.setAttribute("cinemaHalls", cinemaHalls);

            request.getRequestDispatcher("/addMovieSession.jsp").forward(request, response);
        } else if (path.startsWith("/deleteMovieSession")) {
            int movieSessionId = Integer.parseInt(request.getParameter("movieSessionId"));
            int movieId = Integer.parseInt(request.getParameter("movieId"));
            MovieSession movieSession = movieSessionService.getMovieSession(movieSessionId);
            movieSessionService.removeMovieSession(movieSession);
            response.sendRedirect("movieDetails?movieId=" + movieId);



        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getServletPath();
        if (path.startsWith("/addMovieSession")) {
            try {
                addMovieSession(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addMovieSession(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        MovieSession movieSession = new MovieSession();
        int HallId = Integer.parseInt(request.getParameter("hallId"));
        int movieId = Integer.parseInt(request.getParameter("movieId"));
        String date = request.getParameter("date");
        Movie movie = movieService.getMovie(movieId);
        CinemaHall cinemaHall = cinemaHallService.getCinemaHall(HallId);
        movieSession.setMovie(movie);
        movieSession.setHall(cinemaHall);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date formattedDate = formatter.parse(date);

        movieSession.setSessionDate(formattedDate);
        movieSessionService.createMovieSession(movieSession);
        response.sendRedirect("movieDetails?movieId=" + movieId);

    }

    public void destroy() {
    }
}
