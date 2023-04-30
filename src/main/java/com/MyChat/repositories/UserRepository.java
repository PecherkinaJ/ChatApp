package com.MyChat.repositories;

import java.util.ArrayList;
import java.util.Formatter;

import com.MyChat.user.AuthUser;
import com.MyChat.user.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.MyChat.user.NewUser;

import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        String tableCreation = "CREATE TABLE IF NOT EXISTS users_table ( " +
            "id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
            "email varchar(50) UNIQUE NOT NULL, " +
            "password varchar(50) NOT NULL, " +
            "nickname varchar(50) UNIQUE NOT NULL) ";
        jdbc.update(tableCreation);
    }

    public void storeNewUser(NewUser newUser) throws SQLException {
        String sql = new Formatter()
                .format("INSERT INTO users_table (email, password, nickname) VALUES ('%s', '%s', '%s')",
                        newUser.getEmail(), newUser.getPassword(), newUser.getNickname())
                .toString();
        jdbc.update(sql);
    }

    public List<NewUser> getAllUsers() {
        String sql = "SELECT * FROM users_table";
        return jdbc.query(sql, new UserRowMapper());
    }

    public boolean authUser(AuthUser user) throws SQLException {
        if (user.getEmail() != null) {
            String sql = new Formatter()
                    .format("SELECT * FROM users_table where email = '%s' and password = '%s'",
                            user.getEmail(), user.getPassword())
                    .toString();
            System.out.println("sqlEmail = " + sql);

            RowMapper<NewUser> mapper = (r, i) -> {
                NewUser rowObject = new NewUser();
                rowObject.setId(r.getInt("id"));
                rowObject.setEmail(r.getString("email"));
                rowObject.setPassword(r.getString("password"));
                rowObject.setNickname(r.getString("nickname"));
                return rowObject;
            };
            List<NewUser> userList = jdbc.query(sql, mapper);
            if (userList.isEmpty()) return false;
            else return userList.size() <= 1;

        } else
            return false;
    }
}
