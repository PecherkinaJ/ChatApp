package com.MyChat.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.MyChat.user.NewUser;

import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void storeNewUser(NewUser newUser) {
        String sql = "INSERT INTO users VALUES (null, ?, ?, ?)";
        // так почему-то не работает
        //INSERT INTO users (email, password, nickname) VALUES (?, ?, ?)  =>> Значение NULL не разрешено для поля "NICKNAME"
        jdbc.update(sql, newUser.getEmail(), newUser.getPassword(), newUser.getNickName());
    }

    public List<NewUser> getAllUsers(){
        String sql = "SELECT * FROM users";
        RowMapper<NewUser> mapper = (r, i) -> {
            NewUser rowObject = new NewUser();
            rowObject.setId(r.getInt("id"));
            rowObject.setEmail(r.getString("email"));
            rowObject.setPassword(r.getString("password"));
            rowObject.setNickName(r.getString("nickname"));
            return rowObject;
        };
        return jdbc.query(sql, mapper);
    }
}
