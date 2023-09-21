package com.estureview.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UserApp")
public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userapp_id;

    private String name;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    private Date registration_date;
    private String role;

    // getters, setters, constructors...
}