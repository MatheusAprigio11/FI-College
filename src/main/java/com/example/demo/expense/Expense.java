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

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String expenseName;
    private String expenseDate;
    private Float value;
}
