package com.estureview.backend.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    private Integer reviewId;
    private String comment;
    private Integer rating;
    private Date reviewDate;
    private String status;
    private Integer userappId;
    private Integer professorId;
    private Integer courseId;

    // Getters and Setters
}