package com.estureview.backend.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ReviewComment")
public class ReviewComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "comment_date", nullable = false)
    private Date commentDate;

    // Getters, Setters, Constructors, equals(), hashCode(), toString()
}