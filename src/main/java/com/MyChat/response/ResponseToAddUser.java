package com.MyChat.response;

public class ResponseToAddUser {
    private String status;

    public static ResponseToAddUser of(String status){
        ResponseToAddUser responseOK = new ResponseToAddUser();
        responseOK.setStatus(status);
        return responseOK;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
