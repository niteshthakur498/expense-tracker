package com.nitesh.ExpenseTracker.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmptyResponse implements Serializable {
}
