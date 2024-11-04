package com.example.demo.controller.history;

import com.example.demo.model.history.DailyFinancialSummary;
import com.example.demo.model.history.MonthlyFinancialSummary;
import com.example.demo.service.history.FinancialHistoryService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/finance")
public class FinancialHistoryController {

    @Autowired
    private FinancialHistoryService financialHistoryService;

    @GetMapping("/history")
    public ResponseEntity<List<DailyFinancialSummary>> getFinancialHistory() {
        final var history = financialHistoryService.getDailyFinancialHistory();
        return ResponseEntity.ok(history);
    }

    @GetMapping("/balance")
    public ResponseEntity<MonthlyFinancialSummary> getMonthlySumarry() {
        final var summary = financialHistoryService.getMonthlySummary();
        return ResponseEntity.ok(summary);
    }
}
