package com.nitesh.ExpenseTracker.mapper;

import com.nitesh.ExpenseTracker.dto.ExpenseEventRequestDTO;
import com.nitesh.ExpenseTracker.dto.ExpenseEventResponseDTO;
import com.nitesh.ExpenseTracker.dto.ExpenseRequestDTO;
import com.nitesh.ExpenseTracker.entity.ExpenseEvent;

public interface ExpenseEventMapper {

    ExpenseEvent toEntity(ExpenseEventRequestDTO expenseEventRequestDTO);

    ExpenseEventResponseDTO toResponseDTO(ExpenseEvent expenseEvent);

    void map(ExpenseEventRequestDTO expenseRequestDTO, ExpenseEvent existingExpenseEvent);
}
