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
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long professor_id;

    @OneToOne
    @JoinColumn(name = "userapp_id")
    private UserApp user;

    private String faculty;
    private Date join_date;

    // getters, setters, constructors...
}