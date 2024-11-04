package com.example.demo.model.expense;

import java.math.BigDecimal;
import java.time.LocalDate;

public record  DataNewExpense(
        String expenseName,
                             BigDecimal expenseValue,
                             Categories categories
                             ) {

}
