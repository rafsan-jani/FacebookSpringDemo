package net.therap.facebook.utils;

import net.therap.facebook.entities.UserInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: rafsan.jani
 * @since: 11/30/15.
 */
public class UserInfoMapper implements RowMapper<UserInfo> {
    @Override
    public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserInfo userInfo = null;
        if (rs != null) {
            userInfo = new UserInfo();
            userInfo.setUserId(rs.getInt("user_id"));
            userInfo.setUserName(rs.getString("email"));
            userInfo.setPassword(rs.getString("password"));
        }

        return userInfo;
    }
}
