package com.estureview.backend.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer reviewId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "comment")
    private String comment;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "review_date", nullable = false)
    private Date reviewDate;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "review")
    private List<ReviewComment> reviewComments;

    @OneToMany(mappedBy = "review")
    private List<ReviewTag> reviewTags;

    // Getters, Setters, Constructors, equals(), hashCode(), toString()
}