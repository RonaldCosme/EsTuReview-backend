package com.estureview.backend.dtos;

import com.estureview.backend.entities.ReviewComment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewCommentDTO {

    private Long comment_id;
    private Long review_id;
    private Long userapp_id;
    private String text;
    private String tag;
    private Date comment_date;

    public ReviewCommentDTO(ReviewComment reviewComment) {
    }

    // getters, setters, constructors...
}