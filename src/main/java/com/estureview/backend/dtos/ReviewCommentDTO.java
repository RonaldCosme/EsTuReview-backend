package com.estureview.backend.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCommentDTO {

    private Integer commentId;
    private String text;
    private String tag;
    private Date commentDate;
    private Integer reviewId;
    private Integer userappId;

    // Getters and Setters
}
