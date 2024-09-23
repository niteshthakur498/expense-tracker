package com.nitesh.ExpenseTracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "et_category")
public class ExpenseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_id_seq_generator")
    @SequenceGenerator(name = "category_id_seq_generator", sequenceName = "et_seq_category_id", allocationSize = 1)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "category_title")
    private String categoryTitle;

    @Column(name = "category_description")
    private String categoryDescription;
}
