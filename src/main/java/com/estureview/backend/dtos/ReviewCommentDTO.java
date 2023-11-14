package com.estureview.backend.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCommentDTO {

    private Long commentId;
    private String text;
    private String tag;
    private Date commentDate;
    private Long reviewId;

    // Getters and Setters
}
