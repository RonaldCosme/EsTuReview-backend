package com.estureview.backend.dtos;

import com.estureview.backend.entities.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    private Long review_id;
    private Long userapp_id;
    private Long professor_id;
    private Long course_id;
    private String comment;
    private Integer rating;
    private Date review_date;
    private String status;

    public ReviewDTO(Review review) {
    }

    // getters, setters, constructors...
}