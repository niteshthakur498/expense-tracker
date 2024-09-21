package com.nitesh.ExpenseTracker.controller;

import com.nitesh.ExpenseTracker.dto.ExpenseRequestDTO;
import com.nitesh.ExpenseTracker.dto.ExpenseResponseDTO;
import com.nitesh.ExpenseTracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class ExpenseController {


    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/{userId}/expenses")
    public ResponseEntity<List<ExpenseResponseDTO>> getExpenseByUser(@PathVariable String userId) {
        List<ExpenseResponseDTO> userExpenses = expenseService.getAllUserExpenses(userId);
        return ResponseEntity.ok(userExpenses);
    }

    @PostMapping("/{userId}/expenses")
    public ResponseEntity<ExpenseResponseDTO> createExpense(@PathVariable String userId,
                                                            @RequestBody ExpenseRequestDTO expenseRequest) {
        ExpenseResponseDTO createdExpense = expenseService.addExpense(expenseRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdExpense);

    }

    @PutMapping("/{userId}/expenses/{expenseId}")
    public ResponseEntity<ExpenseResponseDTO> updateExpense(@PathVariable String userId,
                                                            @PathVariable String expenseId,
                                                            @RequestBody ExpenseRequestDTO expenseRequest) {
        ExpenseResponseDTO expenseResponseDTO = expenseService.updateExpense(userId, expenseId, expenseRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(expenseResponseDTO);

    }

    @GetMapping("/{userId}/expenses/{expenseId}")
    public ResponseEntity<ExpenseResponseDTO> getExpenseById(@PathVariable String userId,
                                                             @PathVariable String expenseId) {
        ExpenseResponseDTO expenseResponseDTO = expenseService.getExpenseById(userId, expenseId);
        return ResponseEntity.status(200)
                .body(expenseResponseDTO);
    }

    @DeleteMapping("/{userId}/expenses/{expenseId}")
    public ResponseEntity<String> deleteExpense(@PathVariable String userId,
                                                @PathVariable String expenseId) {

        expenseService.deleteExpense(userId, expenseId);
        return ResponseEntity.ok("Expense Successfully Deleted");
    }
}
