package com.estureview.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAppDTO {

    private Integer id;
    private String name;
    private String email;
    private String password;
    private Date registrationDate;
    private String role;
    private Integer universityId;

    // Getters y Setters
}