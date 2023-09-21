package com.estureview.backend.dtos;

import com.estureview.backend.entities.UserApp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAppDTO {

    private Long userapp_id;
    private String name;
    private String email;
    // Es una buena práctica no enviar el password en el DTO
    private Long university_id;
    private Date registration_date;
    private String role;

    public UserAppDTO(UserApp userApp) {
    }

    // getters, setters, constructors...

}