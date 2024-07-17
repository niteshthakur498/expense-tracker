package com.nitesh.ExpenseTracker.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @GetMapping("")
    public String getAllCategories( @RequestParam String expense,@RequestParam("file") MultipartFile file){
        //System.out.println(request.toString());
        System.out.println(expense.toString());
        System.out.println(file.getContentType());
        return "Got it";
    }

}
