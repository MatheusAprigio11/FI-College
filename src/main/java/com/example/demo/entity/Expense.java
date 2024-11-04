package com.example.demo.entity;

import com.example.demo.model.expense.Categories;
import com.example.demo.model.expense.DataNewExpense;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "Expenses")
@Entity(name = "Expense")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Expense {

    public Expense(DataNewExpense data) {
        this.expenseName=data.expenseName();
        this.expenseValue=data.expenseValue();
        this.expenseDate=LocalDate.now();
        this.categories=data.categories();
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String expenseName;
    private LocalDate expenseDate;
    private BigDecimal expenseValue;

    @Enumerated(EnumType.STRING)
    private Categories categories;


}
