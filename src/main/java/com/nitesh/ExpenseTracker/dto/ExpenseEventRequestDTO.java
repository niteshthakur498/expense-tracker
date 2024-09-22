package com.nitesh.ExpenseTracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseEventRequestDTO {

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("eventTitle")
    private String eventTitle;

    @JsonProperty("eventDescription")
    private String eventDescription;

}
