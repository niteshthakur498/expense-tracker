package com.nitesh.ExpenseTracker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "et_categories")
public class ExpenseCategory {

    @Id
    @Column(name = "category_Id")
    private String categoryId;

    @Column(name = "category_description")
    private String categoryDescription;
}
