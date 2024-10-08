package com.example.demo.expense;

import com.example.demo.entity.Expense;

public record GetExpenseData(
        String expenseName,
        Categories categories,
        String expenseDate,
        Float expenseValue) {

        public GetExpenseData(Expense expense){
            this(expense.getExpenseName(), expense.getCategories(), expense.getExpenseDate(), expense.getExpenseValue());
        }
}
