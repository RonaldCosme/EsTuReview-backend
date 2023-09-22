package com.estureview.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private Integer id;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "join_date")
    private Date joinDate;

    @ManyToOne
    @JoinColumn(name = "userapp_id", nullable = false)
    private UserApp user;

    @OneToMany(mappedBy = "professor")
    private List<Review> reviews;

    // Getters y Setters
}