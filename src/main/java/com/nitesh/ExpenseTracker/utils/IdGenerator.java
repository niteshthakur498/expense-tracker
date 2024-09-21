package com.nitesh.ExpenseTracker.utils;

import java.util.Calendar;

public class IdGenerator {
    public static String generateId(String prefix) {
        Calendar calendar = Calendar.getInstance();
        return prefix.toUpperCase() + "-" + calendar.get(Calendar.YEAR) + "-" + System.currentTimeMillis();
    }
}
