package com.estureview.backend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Integer tagId;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "tag")
    private List<ReviewTag> reviewTags;

    // Getters, Setters, Constructors, equals(), hashCode(), toString()
}
