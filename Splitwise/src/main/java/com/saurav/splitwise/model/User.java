package com.saurav.splitwise.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class User extends BaseModel{

    private String username;
    private String phoneNumber;
    private String password;


}
