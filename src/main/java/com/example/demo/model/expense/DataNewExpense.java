package com.example.demo.model.expense;

import java.math.BigDecimal;
import java.time.LocalDate;

public record  DataNewExpense(
        String expenseName,
                             LocalDate expenseDate,
                             BigDecimal expenseValue,
                             Categories categories
                             ) {

}
