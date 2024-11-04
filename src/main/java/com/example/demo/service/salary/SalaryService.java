package com.example.demo.service.salary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Salary;
import com.example.demo.model.salary.SalaryModel;
import com.example.demo.repository.SalaryRepository;

import java.time.LocalDate;

@Service
public class SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    public Salary saveSalary(SalaryModel salaryModel) {
        var salary = Salary.builder().value(salaryModel.getValue()).recievedDate(LocalDate.now()).build();
        return salaryRepository.save(salary);
    }
}
