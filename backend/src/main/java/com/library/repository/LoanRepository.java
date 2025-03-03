package com.library.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
@Repository
public class LoanRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Long loanBook(Long userId, Long copyId, Long statusLoanId, LocalDate loanDate, LocalDate expirationDate) {
        String loanSql = "INSERT INTO loan (user_id, copy_id, status_loan_id, loan_date, expiration_date) VALUES (?, ?, ?, ?, ?)";
        KeyHolder loankeyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(loanSql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, userId);
            ps.setLong(2, copyId);
            ps.setLong(3, statusLoanId);
            ps.setDate(4, Date.valueOf(loanDate));
            ps.setDate(5, Date.valueOf(expirationDate));

            return ps;
        }, loankeyHolder);
        long loanId = loankeyHolder.getKey().longValue();
        return loanId;
    }

    public void returnBook (Long id, LocalDate returnDate){
        String returnBookSql= "UPDATE loan SET return_date=? WHERE id=?";
        jdbcTemplate.update(returnBookSql, id, returnDate);
    }
}
