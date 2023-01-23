package edu.school21.cinema.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private String password;
    private List<Info> infoList;
}
