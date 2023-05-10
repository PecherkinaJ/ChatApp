package com.MyChat.user;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OnlineUserRowMapper implements RowMapper<OnlineUser> {
    @Override
    public OnlineUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        OnlineUser user = new OnlineUser();
        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("email"));
        return user;
    }

}
