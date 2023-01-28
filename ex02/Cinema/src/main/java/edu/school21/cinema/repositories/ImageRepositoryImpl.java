package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Image;
import org.springframework.jdbc.core.JdbcTemplate;

public class ImageRepositoryImpl implements ImageRepository{

    private JdbcTemplate jdbc;
    public ImageRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    @Override
    public void saveImage(Image image) {
        jdbc.update("insert into images(owner, name, uniqName, mime, size) values (?, ?, ?, ?, ?)",
                image.getOwner(),
                image.getName(),
                image.getUniqName(),
                image.getMime(),
                image.getSize());
    }
}
