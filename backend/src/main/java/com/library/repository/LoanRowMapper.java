package com.library.repository;
import com.library.model.Loan;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanRowMapper implements RowMapper<Loan> {
    @Override
    public Loan mapRow (ResultSet rs, int rowNum) throws SQLException {
        return new Loan(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getLong("copy_id"),
                rs.getLong("status_loan_id"),
                rs.getDate("loan_date"),
                rs.getDate("return_date"),
                rs.getDate("expiration_date")

        );
    }
}
