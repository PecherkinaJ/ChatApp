package com.MyChat.user;

public class NewUser {
    private int id;
    private String nickName;
    private String email;
    private String password;

//    public NewUser(String email, String password, String nickName) {
//        this.email = email;
//        this.password = password;
//        this.nickName = nickName;
//    }

//    public NewUser() {
//
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
