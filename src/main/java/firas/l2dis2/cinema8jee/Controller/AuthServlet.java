//Icon : src/main/resources/java-servlet.png

package firas.l2dis2.cinema8jee.Controller;

import firas.l2dis2.cinema8jee.Entity.User;
import firas.l2dis2.cinema8jee.Service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "AuthServlet", value = {"/","/logout"})
public class AuthServlet extends HttpServlet {
    private UserService userService;

    public void init() {
        userService = new UserService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        String path = request.getServletPath();
        if (path.equals("/logout")) {
            System.out.println("logout");
            session.invalidate();
            response.sendRedirect("/");
            return;
        }
        if (session.getAttribute("email") != null) {
            response.sendRedirect("CinemaHalls");
            return;
        }
        request.getRequestDispatcher("/auth.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userService.login(email, password);
        if (user != null) {

            session.setAttribute("email", email);

            response.sendRedirect("CinemaHalls");


        } else {
            session.setAttribute("error", "Invalid email or password");
            response.sendRedirect("/");
        }
    }

    public void destroy() {
    }
}
