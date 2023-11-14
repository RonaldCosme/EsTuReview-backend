package com.estureview.backend.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    private Long reviewId;
    private String comment;
    private Integer rating;
    private Date reviewDate;
    private String status;
    private Long professorId;
    private Long courseId;

    // Getters and Setters
}
