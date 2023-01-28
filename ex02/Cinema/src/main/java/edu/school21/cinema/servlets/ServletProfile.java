package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import edu.school21.cinema.services.ImagesService;
import org.springframework.context.ApplicationContext;
import sun.misc.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Base64;

@MultipartConfig
@WebServlet(name = "profile", value = "/profile")
public class ServletProfile extends HttpServlet {
    private  String path;
    private ImagesService imagesService;

    @Override
    public void init() throws ServletException {
        ApplicationContext springContext = (ApplicationContext) this.getServletContext().getAttribute("springContext");
        this.path = springContext.getBean("path", String.class);
        this.imagesService = springContext.getBean("imagesService", ImagesService.class);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        req.getSession().setAttribute("path", this.path);
        int size = user.getImageList().size();
        if (size > 0) {
            String uniqName = user.getImageList().get(size - 1).getUniqName();
            try (InputStream is = Files.newInputStream(Paths.get(path + File.separator + uniqName))) {
                byte[] array = IOUtils.readAllBytes(is);
                req.getSession().setAttribute("img", Base64.getEncoder().encodeToString(array));
            } catch (NoSuchFileException ignored) {

            }
        }
        req.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file");
        File file = new File(path + File.separator);
        if (part.getSize() > 0) {
            file.mkdir();
            imagesService.save(req, part, path);
        }
        part.delete();
        resp.sendRedirect("/profile");
    }
}
