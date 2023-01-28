package edu.school21.cinema.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Image {
    private Integer owner;
    private String name;
    private String uniqName;
    private String mime;
    private long size;

    public Image(){};
}
