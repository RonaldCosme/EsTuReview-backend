package com.estureview.backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "ReviewTag")
public class ReviewTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_tag_id")
    private Integer reviewTagId;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    // Getters, Setters, Constructors, equals(), hashCode(), toString()
}