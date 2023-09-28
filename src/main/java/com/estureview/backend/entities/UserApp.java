package com.estureview.backend.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UserApp")
public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userapp_id")
    private Integer userappId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @OneToMany(mappedBy = "userApp")
    private Set<Review> reviews;

    @OneToMany(mappedBy = "userApp")
    private Set<Professor> professors;

    @OneToMany(mappedBy = "userApp")
    private Set<ReviewComment> reviewComments;

    @OneToMany(mappedBy = "admin")
    private Set<ModerationAction> moderationActions;

    public void setRole(Role role) {
        this.role = role;
    }
    // Getters and Setters
}

