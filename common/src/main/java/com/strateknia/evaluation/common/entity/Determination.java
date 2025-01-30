package com.strateknia.evaluation.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Determination {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer qualification;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String recommendations;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String error;

    public void addPoints(int points) {
        qualification+= points;
    }
}
