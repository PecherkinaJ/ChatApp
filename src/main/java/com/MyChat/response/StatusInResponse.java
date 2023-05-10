package com.MyChat.response;

public class StatusInResponse {
    private String status;

    public static StatusInResponse of(String status){
        StatusInResponse response = new StatusInResponse();
        response.setStatus(status);
        return response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
