package edu.school21.cinema.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class Info {
    private Timestamp date;
    private String ip;
}
