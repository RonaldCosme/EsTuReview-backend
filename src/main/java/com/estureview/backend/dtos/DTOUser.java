package com.estureview.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class DTOUser {
    private Long id;

    private String userName;
    private String password;
    private String type;
    private String firstName;
    private String lastName;
    private Date birthdate;
}
