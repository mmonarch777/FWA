package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Info;

import java.util.List;

public interface InfoRepository {
    void saveInfo(Integer id, String ip);
    List<Info> getInfo(Integer id);
}
