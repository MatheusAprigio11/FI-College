package com.example.demo.expense;

import jakarta.persistence.*;
import lombok.*;

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
        this.expenseDate=data.expenseDate();
        this.categories=data.categories();
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String expenseName;
    private String expenseDate;
    private Float expenseValue;

    @Enumerated(EnumType.STRING)
    private Categories categories;


}
