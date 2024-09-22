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
@Table(name = "et_category")
public class ExpenseCategory {

    @Id
    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "category_title")
    private String categoryTitle;

    @Column(name = "category_description")
    private String categoryDescription;
}
