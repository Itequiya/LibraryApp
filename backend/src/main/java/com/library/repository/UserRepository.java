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

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        String sql = "SELECT u.id, u.role_id, u.name, u.lastname, u.mail, u.phone " +
                "FROM user u ";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }
    public User findByName(String name, String lastname) {
        String sql = "SELECT u.id, u.role_id, u.name, u.lastname, u.mail, u.phone " +
                "FROM user u  WHERE u.name = ? and u.lastname = ?";
        return jdbcTemplate.queryForObject(sql, new UserRowMapper(),name, lastname);
    }

    public User addUser(User user) {
        String userSql = "INSERT INTO user (role_id, name, lastname, mail, phone) VALUES (?,?, ?, ?, ?)";
        KeyHolder userkeyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(userSql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, user.getRole_id());
            ps.setString(2, user.getName());
            ps.setString(3, user.getLastname());
            ps.setString(4, user.getMail());
            ps.setString(5,user.getPhone());
            return ps;
        }, userkeyHolder);
        long userId = userkeyHolder.getKey().longValue();
        // Asignar los IDs generados a los objetos
        user.setId(userId);
        return user;
    }

    public void deleteUser(Long id) {
        String deleteCopySql = "DELETE FROM user WHERE id = ?";
        jdbcTemplate.update(deleteCopySql, id);
    }

}
