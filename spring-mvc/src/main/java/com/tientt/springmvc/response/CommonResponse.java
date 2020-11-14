package com.tientt.springmvc.response;

import java.io.Serializable;

public class CommonResponse implements Serializable {
    private boolean success;
    private String message;
    private String error;

    public CommonResponse() {
    }

    public CommonResponse(boolean success, String message, String error) {
        this.success = success;
        this.message = message;
        this.error = error;
    }

    public static CommonResponse build(boolean success, String message, String error) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setSuccess(success);
        commonResponse.setMessage(message);
        commonResponse.setError(error);
        return commonResponse;
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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
