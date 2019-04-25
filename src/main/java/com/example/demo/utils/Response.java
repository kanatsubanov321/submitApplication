package com.example.demo.utils;

public class Response {
    private boolean success;
    private String message;
    private Object client;

    public Response() {
    }

    public Response(boolean success, String message, Object client) {
        this.success = success;
        this.message = message;
        this.client = client;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getClient() {
        return client;
    }

    public void setClient(Object client) {
        this.client = client;
    }
}
