package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import edu.school21.cinema.services.UsersService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "signIn", value = {"/signIn", ""})
public class ServletSignIn extends HttpServlet {
    private UsersService usersService;

    @Override
    public void init() throws ServletException {
        ApplicationContext springContext =
                (ApplicationContext) this.getServletContext().getAttribute("springContext");
        usersService = springContext.getBean("usersService", UsersService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");
        Optional<User> obj = usersService.findUser(req);
        if (obj.isPresent()) {
            User user = obj.get();
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("/profile");
        } else {
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
