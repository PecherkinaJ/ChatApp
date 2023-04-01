package user;

import dataBase.DataBase;

public class User {
    private String nickName;
    private String email;
    private String password;
    DataBase db;

    public void registerNewUser(String email, String password, String nickName){
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        sendUserToDB();
    }

    private void sendUserToDB(){
        db = new DataBase();
        // записываем данные в БД и печатаем результат
        System.out.println(db.setNewUser(email, password, nickName));
    }
}
