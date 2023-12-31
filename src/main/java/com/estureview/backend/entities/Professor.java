package com.estureview.backend.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private Long professorId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "join_date")
    private Date joinDate;


    @OneToMany(mappedBy = "professor")
    private Set<Review> reviews;

    @Transient
    private String userFirstname;
    @Transient
    private String userLastname;


    public String getUserFirstname (){
        return this.getUser().getFirstName();
    }

    public String getUserLastname (){
        return this.getUser().getLastName();
    }

    // Getters and Setters
}
