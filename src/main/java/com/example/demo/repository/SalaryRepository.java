package com.example.demo.repository;

import com.example.demo.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Salary;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {

    List<Salary> findByRecievedDateBetween(LocalDate starDate, LocalDate localDate);
}