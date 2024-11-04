package com.example.demo.service.history;

import com.example.demo.entity.Expense;
import com.example.demo.entity.Salary;
import com.example.demo.model.history.DailyFinancialSummary;
import com.example.demo.model.history.MonthlyFinancialSummary;
import com.example.demo.repository.ExpenseRepository;
import com.example.demo.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FinancialHistoryService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private SalaryRepository salaryRepository;

    public List<DailyFinancialSummary> getDailyFinancialHistory() {
        List<DailyFinancialSummary> dailySummaries = new ArrayList<>();

        Map<LocalDate, List<Expense>> expensesByDate = expenseRepository.findAll()
                .stream().collect(Collectors.groupingBy(Expense::getExpenseDate));

        Map<LocalDate, List<Salary>> salaryByDate = salaryRepository.findAll()
                .stream().collect(Collectors.groupingBy(Salary::getRecievedDate));

        Set<LocalDate> allDates = new HashSet<>();
        allDates.addAll(expensesByDate.keySet());
        allDates.addAll(salaryByDate.keySet());

        BigDecimal runningBalance = BigDecimal.ZERO;

        for (LocalDate date : allDates) {
            List<Expense> dailyExpenses = expensesByDate.getOrDefault(date, Collections.emptyList());
            List<Salary> dailySalaries = salaryByDate.getOrDefault(date, Collections.emptyList());

            BigDecimal dailyIncome = dailySalaries.stream()
                    .map(Salary::getValue)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal dailyExpenseTotal = dailyExpenses.stream()
                    .map(Expense::getExpenseValue)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            runningBalance = runningBalance.add(dailyIncome).subtract(dailyExpenseTotal);

            DailyFinancialSummary summary = DailyFinancialSummary.builder().date(date).balance(runningBalance).build();
            dailySummaries.add(summary);
        }

        dailySummaries.sort(Comparator.comparing(DailyFinancialSummary::date));
        return dailySummaries;
    }

    public MonthlyFinancialSummary getMonthlySummary() {
        LocalDate today = LocalDate.now();
        YearMonth currentMonth = YearMonth.of(today.getYear(), today.getMonth());

        BigDecimal totalExpenses = expenseRepository.findByExpenseDateBetween(
                        currentMonth.atDay(1),
                        currentMonth.atEndOfMonth()
                ).stream()
                .map(Expense::getExpenseValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalSalary = salaryRepository.findByRecievedDateBetween(
                        currentMonth.atDay(1),
                        currentMonth.atEndOfMonth()
                ).stream()
                .map(Salary::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal balance = totalSalary.subtract(totalExpenses);

        return new MonthlyFinancialSummary(totalExpenses, totalSalary, balance);
    }
}
