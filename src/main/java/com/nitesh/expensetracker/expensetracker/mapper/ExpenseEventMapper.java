package com.nitesh.expensetracker.expensetracker.mapper;

import com.nitesh.expensetracker.expensetracker.dto.ExpenseEventRequestDTO;
import com.nitesh.expensetracker.expensetracker.dto.ExpenseEventResponseDTO;
import com.nitesh.expensetracker.expensetracker.entity.ExpenseEvent;

public interface ExpenseEventMapper {

    ExpenseEvent toEntity(ExpenseEventRequestDTO expenseEventRequestDTO);

    ExpenseEventResponseDTO toResponseDTO(ExpenseEvent expenseEvent);

    void map(ExpenseEventRequestDTO expenseRequestDTO,
             ExpenseEvent existingExpenseEvent);
}
