package com.estureview.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniversityDTO {
    private Long id;
    private String name;
    private String campus;
    private String location;
    private String description;
}
