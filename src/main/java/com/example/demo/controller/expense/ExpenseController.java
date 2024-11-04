package com.example.demo.controller.expense;

import com.example.demo.model.expense.DataNewExpense;
import com.example.demo.entity.Expense;
import com.example.demo.repository.ExpenseRepository;
import com.example.demo.model.expense.GetExpenseData;
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
        return repository.findAll().stream().map(GetExpenseData::new).toList();
    }
}
