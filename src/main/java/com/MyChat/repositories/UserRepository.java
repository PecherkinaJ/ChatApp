package com.MyChat.repositories;

import java.util.Formatter;

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
        RowMapper<NewUser> mapper = (r, i) -> {
            NewUser rowObject = new NewUser();
            rowObject.setId(r.getInt("id"));
            rowObject.setEmail(r.getString("email"));
            rowObject.setPassword(r.getString("password"));
            rowObject.setNickname(r.getString("nickname"));
            return rowObject;
        };
        return jdbc.query(sql, mapper);
    }
}
