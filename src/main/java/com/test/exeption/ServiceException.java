package com.test.exeption;

public class ServiceException extends RuntimeException{
    private int code;
    String message;
    String detail;

    public ServiceException(int code, String message, String detail) {
        this.code = code;
        this.message = message;
        this.detail = detail;
    }

    public ServiceException(String message, Throwable cause, int code, String detail) {
        super(message, cause);
        this.code = code;
        this.detail = detail;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return detail;
    }

    public void setDetails(String detail) {
        this.detail = detail;
    }
}
