package com.gaian.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gaian.model.db.EngagementDBModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Data
@JsonInclude(NON_EMPTY)
@NoArgsConstructor
@AllArgsConstructor
public class EngagementTask {

    private String triggerId;

    private ChangeEvent event;

    private EngagementDBModel engagement;

    private int engagementIndex;

    private int engagementCount;
}
