package com.codewithmithlesh.bookmanagment.payload;

import java.time.LocalDateTime;

public class ApiErrorResponse {

    private String status;
    private String message;
    private LocalDateTime timestamp;

    public ApiErrorResponse(String status, String message, LocalDateTime timestamp){
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
