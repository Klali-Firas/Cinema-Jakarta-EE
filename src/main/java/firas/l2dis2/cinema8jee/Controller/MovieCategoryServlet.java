package firas.l2dis2.cinema8jee.Controller;

import firas.l2dis2.cinema8jee.Entity.MovieCategory;
import firas.l2dis2.cinema8jee.Service.MovieCategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "MovieCategoryServlet", value = {"/MovieCategories", "/deleteMovieCategory", "/addMovieCategory", "/updateMovieCategory"})
public class MovieCategoryServlet extends HttpServlet {
    MovieCategoryService movieCategoryService;

    public void init() {
        this.movieCategoryService = new MovieCategoryService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session.getAttribute("email") == null) {
            response.sendRedirect("/");
            return;
        }
        String path = request.getServletPath();
        if (path.startsWith("/deleteMovieCategory")) {
            deleteMovieCategory(request, response);
        } else if (path.startsWith("/addMovieCategory")) {
            request.getRequestDispatcher("/createMovieCategory.jsp").forward(request, response);
        } else if (path.equals("/MovieCategories")) {
            getAllMovieCategories(request, response);
        } else if (path.startsWith("/updateMovieCategory")) {
            int id = Integer.parseInt(request.getParameter("categoryId"));
            MovieCategory movieCategory = movieCategoryService.getMovieCategory(id);
            request.setAttribute("movieCategory", movieCategory);
            request.getRequestDispatcher("/updateMovieCategory.jsp").forward(request, response);
        }
    }

    public void getAllMovieCategories(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Collection<MovieCategory> movieCategories = movieCategoryService.getAllMovieCategories();
        request.setAttribute("movieCategories", movieCategories);
        request.getRequestDispatcher("/allMovieCategories.jsp").forward(request, response);
    }

    public void deleteMovieCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("categoryId"));
        movieCategoryService.removeMovieCategory(movieCategoryService.getMovieCategory(id));
        response.sendRedirect("MovieCategories");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session.getAttribute("email") == null) {
            response.sendRedirect("/");
            return;
        }
        String path = request.getServletPath();
        switch (path) {
            case "/addMovieCategory":
                addMovieCategory(request, response);
                break;
            case "/updateMovieCategory":
                updateMovieCategory(request, response);
                break;
        }
    }

    public void addMovieCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String label = request.getParameter("categoryLabel");
        MovieCategory movieCategory = new MovieCategory(null, label);
        movieCategoryService.createMovieCategory(movieCategory);
        response.sendRedirect("MovieCategories");
    }

    public void updateMovieCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("categoryId"));
        String label = request.getParameter("categoryLabel");
        MovieCategory movieCategory = new MovieCategory(id, label);
        movieCategoryService.modifyMovieCategory(movieCategory);
        response.sendRedirect("MovieCategories");
    }

    public void destroy() {
    }
}
