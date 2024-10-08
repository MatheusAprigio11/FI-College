package com.example.demo.service.salary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.salary.Salary;
import com.example.demo.model.salary.SalaryModel;
import com.example.demo.repository.SalaryRepository;

@Service
public class SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    public Salary saveSalary(SalaryModel salaryModel) {
        var salary = Salary.builder().value(salaryModel.getValue()).recievedDate(salaryModel.getRecievedDate()).build();
        return salaryRepository.save(salary);
    }
}
