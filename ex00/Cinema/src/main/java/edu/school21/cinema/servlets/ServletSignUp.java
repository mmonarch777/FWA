package edu.school21.cinema.servlets;

import edu.school21.cinema.services.UsersService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/signUp")
public class ServletSignUp extends HttpServlet {
    private UsersService usersService;

    @Override
    public void init() {
        ApplicationContext springContext =
                (ApplicationContext) this.getServletContext()
                        .getAttribute("springContext");

        usersService = springContext.getBean("usersService", UsersService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (usersService.saveUser(req)){
            resp.sendRedirect("/");
        } else {
            doGet(req, resp);
        }
    }
}
