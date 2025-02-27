package com.library.repository;
import com.library.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import com.library.model.Book;
import java.util.List;
@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        String sql = "SELECT u.id, u.title, b.library_id, b.author, b.pages, b.editorial " +
                "FROM book b ";
        return jdbcTemplate.query(sql, new BookRowMapper());
    }
    public Book findByTitle(String title) {
        String sql = "SELECT b.id, b.title, b.library_id, b.author, b.pages, b.editorial " +
                "FROM book b  WHERE b.title = ?";
        return jdbcTemplate.queryForObject(sql, new BookRowMapper(),title);
    }

    public Book save(Book book) {
        String bookSql = "INSERT INTO book (title, author, pages, editorial, library_id) VALUES (?, ?, ?, ?, ?)";
        KeyHolder bookkeyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(bookSql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPages());
            ps.setString(4, book.getEditorial());
            ps.setLong(5,book.getLibrary_id());
            return ps;
        }, bookkeyHolder);
        long bookId = bookkeyHolder.getKey().longValue();
        // Asignar los IDs generados a los objetos
        book.setId(bookId);
        return book;
    }

    public void deleteByTitle(String title) {
        String getBookIdSql = "SELECT id FROM book WHERE title = ? limit 1";
        Long BookId = jdbcTemplate.queryForObject(getBookIdSql, Long.class, title);
        String deleteCopySql = "DELETE FROM copy WHERE book_id = ?";
        jdbcTemplate.update(deleteCopySql, BookId);
        String deleteBookSql = "DELETE FROM book WHERE title = ?";
        jdbcTemplate.update(deleteBookSql, title);
    }

}
