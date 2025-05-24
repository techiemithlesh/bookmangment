package com.codewithmithlesh.bookmanagment.payload;

public class ApiResponse<T> {

    private String status;
    private T data;
    private int total;

    public ApiResponse(String status, T data, int total){
        this.status = status;
        this.data = data;
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
