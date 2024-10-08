package com.nitesh.expensetracker.expensetracker.controller;

import com.nitesh.expensetracker.expensetracker.dto.ExpenseEventRequestDTO;
import com.nitesh.expensetracker.expensetracker.dto.ExpenseEventResponseDTO;
import com.nitesh.expensetracker.expensetracker.dto.ResponseWrapper;
import com.nitesh.expensetracker.expensetracker.service.ExpenseEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class ExpenseEventController {

    private final ExpenseEventService expenseEventService;


    @Autowired
    private ExpenseEventController(ExpenseEventService expenseEventService) {
        this.expenseEventService = expenseEventService;
    }

    @PostMapping("/{userId}/expense-event")
    public ResponseEntity<ResponseWrapper<ExpenseEventResponseDTO>> createExpenseEvent(@PathVariable Long userId,
                                                                                       @RequestBody ExpenseEventRequestDTO expenseEventRequest) {
        ExpenseEventResponseDTO expenseEventResponseDTO = expenseEventService.addEvent(expenseEventRequest);
        ResponseWrapper<ExpenseEventResponseDTO> response = new ResponseWrapper<>(HttpStatus.OK.value(),
                "Successfully Retrieved",
                expenseEventResponseDTO,
                new ArrayList<>());
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/{userId}/expense-event")
    public ResponseEntity<ResponseWrapper<List<ExpenseEventResponseDTO>>> findAllUserEvents(@PathVariable Long userId) {
        List<ExpenseEventResponseDTO> expenseEvents = expenseEventService.getAllUserEvent(userId);
        ResponseWrapper<List<ExpenseEventResponseDTO>> response = new ResponseWrapper<>(HttpStatus.OK.value(),
                "Successfully Retrieved",
                expenseEvents,
                new ArrayList<>());
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping("/{userId}/expense-event/{eventId}/close")
    public ResponseEntity<ResponseWrapper<ExpenseEventResponseDTO>> closeExpenseEvent(@PathVariable Long userId,
                                                                                      @PathVariable Long eventId) {
        ExpenseEventResponseDTO expenseEventResponseDTO = expenseEventService.closeEvent(userId, eventId);
        ResponseWrapper<ExpenseEventResponseDTO> response = new ResponseWrapper<>(HttpStatus.OK.value(),
                "Successfully Retrieved",
                expenseEventResponseDTO,
                new ArrayList<>());
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping("/{userId}/expense-event/{eventId}/reopen")
    public ResponseEntity<ResponseWrapper<ExpenseEventResponseDTO>> reOpenExpenseEvent(@PathVariable Long userId,
                                                                                       @PathVariable Long eventId) {
        ExpenseEventResponseDTO expenseEventResponseDTO = expenseEventService.reOpenEvent(userId, eventId);
        ResponseWrapper<ExpenseEventResponseDTO> response = new ResponseWrapper<>(HttpStatus.OK.value(),
                "Successfully Retrieved",
                expenseEventResponseDTO,
                new ArrayList<>());
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @DeleteMapping("/{userId}/expense-event/{eventId}")
    public ResponseEntity<ResponseWrapper<String>> deleteExpenseEvent(@PathVariable Long userId,
                                                                      @PathVariable Long eventId) {
        expenseEventService.deleteEvent(userId, eventId);
        ResponseWrapper<String> response = new ResponseWrapper<>(HttpStatus.OK.value(),
                "Successfully Deleted",
                null,
                new ArrayList<>());
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/{userId}/expense-event/{eventId}")
    public ResponseEntity<ResponseWrapper<ExpenseEventResponseDTO>> getExpenseEvent(@PathVariable Long userId,
                                                                                    @RequestBody Long eventId) {
        ExpenseEventResponseDTO expenseEventResponseDTO = expenseEventService.getEventById(userId, eventId);
        ResponseWrapper<ExpenseEventResponseDTO> response = new ResponseWrapper<>(HttpStatus.OK.value(),
                "Successfully Retrieved",
                expenseEventResponseDTO,
                new ArrayList<>());
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
}
