package com.estureview.backend.entities;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private Integer professorId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "join_date")
    private Date joinDate;

    @OneToMany(mappedBy = "professor")
    private List<Review> reviews;

    // Getters, Setters, Constructors, equals(), hashCode(), toString()
}