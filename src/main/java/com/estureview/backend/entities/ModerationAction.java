package com.estureview.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ModerationAction")
public class ModerationAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "action_id")
    private Integer id;

    @Column(name = "action_type", nullable = false)
    private String actionType;

    @Column(name = "action_date", nullable = false)
    private Date actionDate;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private UserApp admin;

    // Getters y Setters
}