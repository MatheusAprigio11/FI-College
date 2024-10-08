package com.example.demo.controller;

import com.example.demo.expense.DataNewExpense;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses")

public class ExpenseController {

    @PostMapping
    public void newExpense(@RequestBody DataNewExpense data){
        System.out.println(data);
    }
}
