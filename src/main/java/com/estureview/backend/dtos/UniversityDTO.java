package com.estureview.backend.dtos;

import com.estureview.backend.entities.University;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniversityDTO {

    private Long university_id;
    private String name;
    private String campus;
    private String location;
    private String description;

    public UniversityDTO(University university) {
    }

    // getters, setters, constructors...
}
