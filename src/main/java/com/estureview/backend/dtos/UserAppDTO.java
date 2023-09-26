package com.estureview.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAppDTO {

    private Integer userappId;
    private String name;
    private String email;
    private Date registrationDate;
    private String role;
    private Integer universityId;

    // Getters and Setters
}

