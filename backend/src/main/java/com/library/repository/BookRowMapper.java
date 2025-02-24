package com.library.repository;
import com.library.model.Book;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book>  {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getLong("library_id"),
                rs.getString("author"),
                rs.getInt("pages"),
                rs.getString("editorial")

        );
    }
}
