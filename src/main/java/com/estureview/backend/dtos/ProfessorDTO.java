package com.estureview.backend.dtos;

import com.estureview.backend.entities.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO {

    private Long professor_id;
    private Long userapp_id;  // Referencia al ID del usuario asociado
    private String faculty;
    private Date join_date;

    public ProfessorDTO(Professor professor) {
    }

    // getters, setters, constructors...
}