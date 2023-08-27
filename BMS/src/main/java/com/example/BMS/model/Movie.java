package com.example.BMS.model;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Movie extends BaseModel{
    private String name;
    private String genre;

}
