package com.estureview.backend.dtos;

import com.estureview.backend.entities.ModerationAction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModerationActionDTO {

    private Long action_id;
    private Long review_id;
    private Long admin_id; // Referencia al ID del administrador
    private String action_type;
    private Date action_date;
    private String comment;

    public ModerationActionDTO(ModerationAction moderationAction) {
    }


    // getters, setters, constructors...
}