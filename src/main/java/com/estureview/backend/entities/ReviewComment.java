package com.estureview.backend.entities;



import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ReviewComment")
public class ReviewComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "tag", nullable = false)
    private String tag;

    @Column(name = "comment_date", nullable = false)
    private Date commentDate;

    @ManyToOne
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;

    @ManyToOne
    @JoinColumn(name = "userapp_id", nullable = false)
    private UserApp userApp;

    // Getters and Setters
}

