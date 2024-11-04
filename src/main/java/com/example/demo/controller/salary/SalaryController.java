package com.example.demo.controller.salary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.salary.SalaryModel;
import com.example.demo.service.salary.SalaryService;

@RestController
@RequestMapping("/api/v1/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @PostMapping
    public ResponseEntity<String> insertSalary(@RequestBody SalaryModel salaryModel) {
        salaryService.saveSalary(salaryModel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Salário inserido com sucesso.");
    }
}