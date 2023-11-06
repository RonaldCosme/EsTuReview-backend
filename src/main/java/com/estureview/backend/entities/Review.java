package com.estureview.backend.entities;



import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer reviewId;

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
    private UserApp userApp;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @OneToMany(mappedBy = "review")
    private Set<ReviewComment> reviewComments;

    @OneToMany(mappedBy = "review")
    private Set<ModerationAction> moderationActions;

    // Getters and Setters
}
