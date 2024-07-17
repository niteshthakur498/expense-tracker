package com.nitesh.ExpenseTracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/static/categories")
public class CategoryController {

    @GetMapping
    public String getALlCategories(){
        return "Got Categories";
    }
}
