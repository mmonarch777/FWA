package edu.school21.cinema.services;

import edu.school21.cinema.models.Image;
import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.ImageRepository;
import sun.misc.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

public class ImagesService {
    private ImageRepository imageRepository;

    public ImagesService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public void save(HttpServletRequest request, Part part, String path){
        String mime = part.getContentType();
        String uniqName = getUniqName(mime);
        try(OutputStream output = Files.newOutputStream(Paths.get(path + File.separator + uniqName))) {
            InputStream input = part.getInputStream();
            byte[] array = IOUtils.readAllBytes(input);
            output.write(array);
            request.getSession().setAttribute("img", Base64.getEncoder().encodeToString(array));
            input.close();

            User user = (User) request.getSession().getAttribute("user");
            Image image = new Image(user.getId(), getFileName(part), uniqName, mime, part.getSize());
            imageRepository.saveImage(image);
            user.getImageList().add(image);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getUniqName(String mime) {
        String type = "." + mime.split("/")[1];
        return UUID.randomUUID().toString().replace("-", "") + type;
    }

    private String getFileName(Part part) {
        String[] content = part.getHeader("content-disposition").split("; ");
        for (String string : content) {
            if (string.startsWith("filename")) {
                return string.substring(string.indexOf('=') + 2, string.length() - 1);
            }
        }
        return null;
    }
}
