package com.MyChat.user;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<NewUser> {
    @Override
    public NewUser mapRow(ResultSet resultSet, int i) throws SQLException {
        NewUser user = new NewUser();
        user.setId(resultSet.getInt("id"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setNickname(resultSet.getString("nickname"));
        return user;
    }
}
