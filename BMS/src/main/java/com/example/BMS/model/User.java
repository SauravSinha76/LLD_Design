package com.example.BMS.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class User extends BaseModel{
    private String name;
    private String mail;
}
