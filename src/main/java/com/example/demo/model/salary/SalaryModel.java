package com.example.demo.model.salary;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
public class SalaryModel {
    private BigDecimal value;
    private LocalDate recievedDate;
}