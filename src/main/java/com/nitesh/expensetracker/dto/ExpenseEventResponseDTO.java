package com.nitesh.expensetracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseEventResponseDTO {

    private Long eventId;

    private Long userId;

    private String eventTitle;

    private String eventDescription;

    private String eventStatus;

    private LocalDateTime eventInputTime;

}
