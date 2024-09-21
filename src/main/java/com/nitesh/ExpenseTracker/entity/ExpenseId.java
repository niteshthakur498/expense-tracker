package com.nitesh.ExpenseTracker.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class ExpenseId implements Serializable {
    private String userId;

    private String expenseId;

    public ExpenseId() {

    }

    public ExpenseId(String userId,
                     String expenseId) {
        this.userId = userId;
        this.expenseId = expenseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ExpenseId))
            return false;
        ExpenseId that = (ExpenseId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(expenseId, that.expenseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, expenseId);
    }
}
