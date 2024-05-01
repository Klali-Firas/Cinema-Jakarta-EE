package firas.l2dis2.cinema8jee.Controller;

import firas.l2dis2.cinema8jee.Entity.CinemaHall;
import firas.l2dis2.cinema8jee.Service.CinemaHallService;
import firas.l2dis2.cinema8jee.dao.DaoCinemaHall;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CinemaHallServlet", value = {"/CinemaHalls", "/deleteCinemaHall", "/addCinemaHall", "/updateCinemaHall"})
public class CinemaHallServlet extends HttpServlet {
    CinemaHallService cinemaHallService;
    public void init() {
        this.cinemaHallService = new CinemaHallService(new DaoCinemaHall());    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getServletPath();
        if(path.startsWith("/deleteCinemaHall")){
            deleteCinemaHall(request, response);

        } else if (path.startsWith("/addCinemaHall")) {
            request.getRequestDispatcher("/createCinemaHall.jsp").forward(request, response);
        } else if (path.equals("/CinemaHalls")) {
            getAllCinemaHalls(request, response);

        } else if (path.startsWith("/updateCinemaHall") ){
            int id = Integer.parseInt(request.getParameter("hallId"));
            CinemaHall cinemaHall = cinemaHallService.getCinemaHall(id);
            request.setAttribute("cinemaHall", cinemaHall);
            request.getRequestDispatcher("/updateCinemaHall.jsp").forward(request, response);

        }

    }
    public void getAllCinemaHalls(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<CinemaHall> cinemaHalls = cinemaHallService.getAllCinemaHalls();
        request.setAttribute("cinemaHalls", cinemaHalls);
        request.getRequestDispatcher("/allCinemaHalls.jsp").forward(request, response);
    }

    public void deleteCinemaHall(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("hallId"));
        cinemaHallService.removeCinemaHall(cinemaHallService.getCinemaHall(id));
        response.sendRedirect("CinemaHalls");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/addCinemaHall":
                addCinemaHall(request, response);
                break;
            case "/updateCinemaHall":
                updateCinemaHall(request, response);
                break;
        }

    }

    public void addCinemaHall(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("hallName");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        CinemaHall cinemaHall = new CinemaHall(null,name, capacity,false);
        cinemaHallService.createCinemaHall(cinemaHall);
        response.sendRedirect("CinemaHalls");
    }

    public void updateCinemaHall(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("hallId"));
        String name = request.getParameter("hallName");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        boolean reservationStatus = request.getParameter("reservationStatus") != null && request.getParameter("reservationStatus").equals("on");
        System.out.println(reservationStatus);
        CinemaHall cinemaHall = new CinemaHall(id, name, capacity, reservationStatus);
        cinemaHallService.modifyCinemaHall(cinemaHall);
        response.sendRedirect("CinemaHalls");
    }







    public void destroy() {
    }
}
