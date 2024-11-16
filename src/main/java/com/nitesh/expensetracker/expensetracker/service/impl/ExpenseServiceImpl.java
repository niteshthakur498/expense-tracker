package com.nitesh.expensetracker.expensetracker.service.impl;

import com.nitesh.expensetracker.expensetracker.dto.ExpenseRequestDTO;
import com.nitesh.expensetracker.expensetracker.dto.ExpenseResponseDTO;
import com.nitesh.expensetracker.expensetracker.entity.Expense;
import com.nitesh.expensetracker.expensetracker.exception.ResourceNotFoundException;
import com.nitesh.expensetracker.expensetracker.mapper.ExpenseMapper;
import com.nitesh.expensetracker.expensetracker.repository.ExpenseRepository;
import com.nitesh.expensetracker.expensetracker.service.ExpenseService;
import com.nitesh.expensetracker.expensetracker.validator.ExpenseValidator;
import com.nitesh.expensetracker.kafkaserviceconnect.dto.PublishMessageRequestDto;
import com.nitesh.expensetracker.kafkaserviceconnect.model.BudgetExceededMessage;
import com.nitesh.expensetracker.kafkaserviceconnect.model.KafkaMessage;
import com.nitesh.expensetracker.kafkaserviceconnect.service.KafkaProducerService;
import com.nitesh.expensetracker.kafkaserviceconnect.util.KafkaServiceClientUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseValidator expenseValidator;
    private final ExpenseMapper expenseMapper;
    private final BudgetService budgetService;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository,
                              ExpenseMapper expenseMapper,
                              ExpenseValidator expenseValidator,
                              BudgetService budgetService
    ) {
        this.expenseRepository = expenseRepository;
        this.expenseMapper = expenseMapper;
        this.expenseValidator = expenseValidator;
        this.budgetService = budgetService;
    }

    @Override
    public ExpenseResponseDTO addExpense(ExpenseRequestDTO expenseRequest) {
        expenseValidator.validateExpense(expenseRequest);
        Expense expense = expenseMapper.toEntity(expenseRequest);
        Expense createdExpense = expenseRepository.save(expense);

        budgetService.processBudgetFunctionality(createdExpense.getUserId(), createdExpense.getEventId());

        return expenseMapper.toResponseDTO(createdExpense);
    }

    @Override
    public ExpenseResponseDTO updateExpense(Long userId,
                                            Long expenseId,
                                            ExpenseRequestDTO expenseRequest) {
        Expense existingExpense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new ResourceNotFoundException("Expense Record not found for Expense: " + expenseId));
        log.debug("Expense Record Found for Modification...");
        expenseMapper.map(expenseRequest, existingExpense);
        Expense updatedExpense = expenseRepository.save(existingExpense);
        return expenseMapper.toResponseDTO(updatedExpense);
    }

    @Override
    public void deleteExpense(Long userId,
                              Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new ResourceNotFoundException("Expense Record not found for Expense: " + expenseId));
        log.debug("Expense Record Found for Deletion..");
        expenseRepository.deleteById(expenseId);
    }

    @Override
    public ExpenseResponseDTO getExpenseById(Long userId,
                                             Long expenseId) {
        log.debug("Entered getExpenseById...");
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new ResourceNotFoundException("Expense Record not found for Expense: " + expenseId));
        log.debug("Expense Record Found...");
        return expenseMapper.toResponseDTO(expense);
    }

    @Override
    public List<ExpenseResponseDTO> getAllUserExpenses(Long userId) {
        return expenseRepository.findByUserId(userId)
                .stream()
                .map(expenseMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExpenseResponseDTO> getExpenseByUserAndEvent(Long userId,
                                                             Long eventId) {
        return expenseRepository.findByUserIdAndEventId(userId, eventId)
                .stream()
                .map(expenseMapper::toResponseDTO)
                .collect(Collectors.toList());

    }
}
