package com.library.repository;
import com.library.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

        public String getCategoryNameById(Long id) {
            String getCategoryNameByIdSql = "SELECT name FROM category WHERE id = ?";
            return jdbcTemplate.queryForObject(getCategoryNameByIdSql, String.class, id);
        }

    public Category addCategory(Category category) {
        String sql = "INSERT INTO category (name) VALUES (?)";
       jdbcTemplate.update(sql, category.getName());
       return category;
    }
}
