package com.nitesh.expensetracker.expensetracker.service;

import com.nitesh.expensetracker.expensetracker.dto.ExpenseEventRequestDTO;
import com.nitesh.expensetracker.expensetracker.dto.ExpenseEventResponseDTO;

import java.util.List;

public interface ExpenseEventService {

    ExpenseEventResponseDTO addEvent(ExpenseEventRequestDTO expenseEventRequest);

    ExpenseEventResponseDTO updateEvent(Long userId,
                                        Long eventId,
                                        ExpenseEventRequestDTO expenseEventRequest);

    void deleteEvent(Long userId,
                     Long eventId);

    ExpenseEventResponseDTO closeEvent(Long userId,
                                       Long eventId);

    ExpenseEventResponseDTO reOpenEvent(Long userId,
                                        Long eventId);

    ExpenseEventResponseDTO getEventById(Long userId,
                                         Long eventId);

    List<ExpenseEventResponseDTO> getAllUserEvent(Long userId);
}
