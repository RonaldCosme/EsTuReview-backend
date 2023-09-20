package com.estureview.backend.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ModerationAction")
public class ModerationAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "action_id")
    private Integer actionId;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private User admin;

    @Column(name = "action_type", nullable = false)
    private String actionType;

    @Column(name = "action_date", nullable = false)
    private Date actionDate;

    @Column(name = "comment")
    private String comment;

    // Getters, Setters, Constructors, equals(), hashCode(), toString()
}