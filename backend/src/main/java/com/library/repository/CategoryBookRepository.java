package com.library.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryBookRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addCategoryToBook(Long bookId, Long categoryId) {
        String sql = "INSERT INTO category_book (book_id, category_id) VALUES (?, ?)";

        jdbcTemplate.update(sql, bookId, categoryId);
    }
}
