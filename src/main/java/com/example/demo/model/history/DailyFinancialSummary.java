package com.example.demo.model.history;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record DailyFinancialSummary(
        LocalDate date,
        BigDecimal balance
) {}
