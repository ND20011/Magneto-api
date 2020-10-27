package com.java.exercise.meli.magneto.exeptionHandler;

import java.util.Date;
import java.util.List;

public class MessageError {

    private String statusCode;
    private String message;
    private String errors;
    private Date date;

    public MessageError(String status, String message) {
        this.statusCode = status;
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
