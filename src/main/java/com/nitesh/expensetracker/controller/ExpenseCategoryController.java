package com.nitesh.expensetracker.controller;

import com.nitesh.expensetracker.dto.ExpenseCategoryDTO;
import com.nitesh.expensetracker.dto.ResponseWrapper;
import com.nitesh.expensetracker.service.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/expense/categories")
public class ExpenseCategoryController {

    private final ExpenseCategoryService expenseCategoryService;

    @Autowired
    public ExpenseCategoryController(ExpenseCategoryService expenseCategoryService) {
        this.expenseCategoryService = expenseCategoryService;
    }

    @GetMapping("")
    public ResponseEntity<ResponseWrapper<List<ExpenseCategoryDTO>>> getALlCategories() {
        List<ExpenseCategoryDTO> expenseCategories = expenseCategoryService.getAllCategories();
        ResponseWrapper<List<ExpenseCategoryDTO>> response = new ResponseWrapper<>(HttpStatus.OK.value(), "Successfully Retrieved", expenseCategories, new ArrayList<>());
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<ResponseWrapper<ExpenseCategoryDTO>> getCategory(@PathVariable Long categoryId) {
        ExpenseCategoryDTO expenseCategory = expenseCategoryService.getCategory(categoryId);
        ResponseWrapper<ExpenseCategoryDTO> response = new ResponseWrapper<>(HttpStatus.OK.value(), "Successfully Retrieved", expenseCategory, new ArrayList<>());
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
}
