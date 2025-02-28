package com.library.repository;
import com.library.model.Copy;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CopyRowMapper implements RowMapper<Copy>{
    @Override
    public Copy mapRow (ResultSet rs, int rowNum) throws SQLException {
        return new Copy(
                rs.getLong("id"),
                rs.getLong("book_id"),
                rs.getLong("status_copy_id")
        );
    }
}
