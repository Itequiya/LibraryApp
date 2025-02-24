package com.library.repository;

import com.library.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class LibraryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Library> findAll() {
        String sql = "SELECT l.id, l.name, a.id AS address_id, a.country, a.city, a.state, a.street, a.zip_code " +
                "FROM library l JOIN address a ON l.address_id = a.id";
        return jdbcTemplate.query(sql, new LibraryRowMapper());
    }

    public Library findByName(String name) {
        String sql = "SELECT l.id, l.name, a.id AS address_id, a.country, a.city, a.state, a.street, a.zip_code " +
                "FROM library l JOIN address a ON l.address_id = a.id WHERE l.name = ?";
        return jdbcTemplate.queryForObject(sql, new LibraryRowMapper(), name);
    }

    public Library save(Library library) {
        String addressSql = "INSERT INTO address (country, city, state, street, zip_code) VALUES (?, ?, ?, ?, ?)";
        KeyHolder addresskeyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(addressSql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, library.getAddress().getCountry());
            ps.setString(2, library.getAddress().getCity());
            ps.setString(3, library.getAddress().getState());
            ps.setString(4, library.getAddress().getStreet());
            ps.setString(5, library.getAddress().getZipCode());
            return ps;
        }, addresskeyHolder);

        long addressId = addresskeyHolder.getKey().longValue();

        String librarySql = "INSERT INTO library (name, address_id) VALUES (?, ?)";
        KeyHolder libraryKeyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(librarySql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, library.getName());
            ps.setLong(2, addressId);
            return ps;
        }, libraryKeyHolder);

        long libraryId = libraryKeyHolder.getKey().longValue();

        // Asignar los IDs generados a los objetos
        library.setId(libraryId);
        library.getAddress().setId(addressId);

        return library;
    }

    public void deleteByName(String name) {
        String getAddressIdSql = "SELECT address_id FROM library WHERE name = ?";
        Long addressId = jdbcTemplate.queryForObject(getAddressIdSql, Long.class, name);

        String deleteLibrarySql = "DELETE FROM library WHERE name = ?";
        jdbcTemplate.update(deleteLibrarySql, name);

        String deleteAddressSql = "DELETE FROM address WHERE id = ?";
        jdbcTemplate.update(deleteAddressSql, addressId);
    }
}
