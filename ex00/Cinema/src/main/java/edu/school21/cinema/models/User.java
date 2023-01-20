package edu.school21.cinema.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private String surname;
    private String phone;
    private String password;
}
