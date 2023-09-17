package com.estureview.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "university")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_id", updatable = false, nullable = false)
    private Long universityId;

    @Column(nullable = false)
    private String name;

    private String campus;

    private String location;

    private String description;
}







