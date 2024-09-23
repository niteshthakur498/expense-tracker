package com.nitesh.ExpenseTracker.controller;

import com.nitesh.ExpenseTracker.dto.ExpenseRequestDTO;
import com.nitesh.ExpenseTracker.dto.ExpenseResponseDTO;
import com.nitesh.ExpenseTracker.dto.ResponseWrapper;
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
    public ResponseEntity<ResponseWrapper<List<ExpenseResponseDTO>>> getExpenseByUser(@PathVariable Long userId) {
        List<ExpenseResponseDTO> userExpenses = expenseService.getAllUserExpenses(userId);
        ResponseWrapper<List<ExpenseResponseDTO>> response = new ResponseWrapper<>(HttpStatus.OK.value(), "Successfully Retrieved", userExpenses, null);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{userId}/expenses")
    public ResponseEntity<ResponseWrapper<ExpenseResponseDTO>> createExpense(@PathVariable Long userId,
                                                                             @RequestBody ExpenseRequestDTO expenseRequest) {
        ExpenseResponseDTO expenseResponseDTO = expenseService.addExpense(expenseRequest);
        ResponseWrapper<ExpenseResponseDTO> response = new ResponseWrapper<>(HttpStatus.OK.value(), "Successfully Created", expenseResponseDTO, null);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);

    }

    @PutMapping("/{userId}/expenses/{expenseId}")
    public ResponseEntity<ResponseWrapper<ExpenseResponseDTO>> updateExpense(@PathVariable Long userId,
                                                                             @PathVariable Long expenseId,
                                                                             @RequestBody ExpenseRequestDTO expenseRequest) {
        ExpenseResponseDTO expenseResponseDTO = expenseService.updateExpense(userId, expenseId, expenseRequest);
        ResponseWrapper<ExpenseResponseDTO> response = new ResponseWrapper<>(HttpStatus.OK.value(), "Successfully Updated", expenseResponseDTO, null);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);

    }

    @GetMapping("/{userId}/expenses/{expenseId}")
    public ResponseEntity<ResponseWrapper<ExpenseResponseDTO>> getExpenseById(@PathVariable Long userId,
                                                                              @PathVariable Long expenseId) {
        ExpenseResponseDTO expenseResponseDTO = expenseService.getExpenseById(userId, expenseId);
        ResponseWrapper<ExpenseResponseDTO> response = new ResponseWrapper<>(HttpStatus.OK.value(), "Successfully Retrieved", expenseResponseDTO, null);
        return ResponseEntity.status(200)
                .body(response);
    }

    @DeleteMapping("/{userId}/expenses/{expenseId}")
    public ResponseEntity<ResponseWrapper<String>> deleteExpense(@PathVariable Long userId,
                                                                 @PathVariable Long expenseId) {

        expenseService.deleteExpense(userId, expenseId);
        ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.OK.value(), "Successfully Deleted", null, null);
        return ResponseEntity.ok(response);
    }
}
