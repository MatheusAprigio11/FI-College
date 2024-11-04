package com.example.demo.model.expense;

import com.example.demo.entity.Expense;

import java.math.BigDecimal;
import java.time.LocalDate;

public record GetExpenseData(
        String expenseName,
        Categories categories,
        LocalDate expenseDate,
        BigDecimal expenseValue) {

        public GetExpenseData(Expense expense){
            this(expense.getExpenseName(), expense.getCategories(), expense.getExpenseDate(), expense.getExpenseValue());
        }
}
