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
@Table(name = "Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "review_date", nullable = false)
    private Date reviewDate;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "userapp_id", nullable = false)
    private UserApp user;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @OneToMany(mappedBy = "review")
    private List<ReviewComment> comments;

    // Getters y Setters
}