package com.estureview.backend.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModerationActionDTO {

    private Integer actionId;
    private String actionType;
    private Date actionDate;
    private String comment;
    private Integer reviewId;
    private Integer adminId;

    // Getters and Setters
}
