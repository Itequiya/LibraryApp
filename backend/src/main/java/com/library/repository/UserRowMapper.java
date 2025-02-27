package com.library.repository;
import com.library.model.User;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User>  {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getLong("id"),
                rs.getLong("role_id"),
                rs.getString("name"),
                rs.getString("lastname"),
                rs.getString("mail"),
                rs.getString("phone")

        );
    }
}