package com.example.demo.model.history;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record MonthlyFinancialSummary(
    BigDecimal totalExepenses,
    BigDecimal totalSalary,
    BigDecimal balance
) {}
