package com.nitesh.expensetracker.mapper;

import com.nitesh.expensetracker.dto.ExpenseEventRequestDTO;
import com.nitesh.expensetracker.dto.ExpenseEventResponseDTO;
import com.nitesh.expensetracker.entity.ExpenseEvent;

public interface ExpenseEventMapper {

    ExpenseEvent toEntity(ExpenseEventRequestDTO expenseEventRequestDTO);

    ExpenseEventResponseDTO toResponseDTO(ExpenseEvent expenseEvent);

    void map(ExpenseEventRequestDTO expenseRequestDTO, ExpenseEvent existingExpenseEvent);
}
