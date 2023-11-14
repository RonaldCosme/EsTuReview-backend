package com.estureview.backend.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {

    private Long professorId;
    private String faculty;
    private Date joinDate;

    // Getters and Setters
}
