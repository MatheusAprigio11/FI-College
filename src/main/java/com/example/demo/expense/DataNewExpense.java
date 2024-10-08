package com.example.demo.expense;

import jakarta.validation.constraints.NotNull;

public record DataNewExpense(
        String expenseName,
                             String expenseDate,
                             Float expenseValue,
                             Categories categories
                             ) {

}
