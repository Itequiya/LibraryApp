package com.library.repository;

import com.library.model.Library;
import com.library.model.Address;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryRowMapper implements RowMapper<Library> {
    @Override
    public Library mapRow(ResultSet rs, int rowNum) throws SQLException {
        Address address = new Address(
                rs.getLong("address_id"),
                rs.getString("country"),
                rs.getString("city"),
                rs.getString("state"),
                rs.getString("street"),
                rs.getString("zip_code")
        );

        return new Library(
                rs.getLong("id"),
                rs.getString("name"),
                address
        );
    }
}