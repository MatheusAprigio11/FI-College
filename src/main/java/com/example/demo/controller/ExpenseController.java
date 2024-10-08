package com.example.demo.controller;

import com.example.demo.expense.DataNewExpense;
import com.example.demo.expense.Expense;
import com.example.demo.expense.ExpenseRepository;
import com.example.demo.expense.GetExpenseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expenses")

public class ExpenseController {

    @Autowired
    private ExpenseRepository repository;

    @PostMapping
    public void newExpense(@RequestBody DataNewExpense data){
        repository.save(new Expense(data));
    }

    @GetMapping
    public List<GetExpenseData> list(){
        return repository.findAll().stream().map(GetExpenseData::new);
    }
}
