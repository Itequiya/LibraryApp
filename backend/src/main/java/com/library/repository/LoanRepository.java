package com.library.repository;
import com.library.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

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
    public Long getCopyIdByLoanId (Long loanId){
        String sql = "SELECT copy_id FROM loan WHERE id= ?";
        return jdbcTemplate.queryForObject(sql, Long.class, loanId);
    }

    public void finishLoan(Long id, LocalDate returnDate){
        String returnBookSql= "UPDATE loan SET return_date=?, status_loan_id= 3 WHERE id=?";
        jdbcTemplate.update(returnBookSql, returnDate, id);
    }

    public List <Loan> getLoanByUser (Long user_id){
        String getLoanByUserSql= "SELECT id, user_id, copy_id, status_loan_id, loan_date, return_date, expiration_date FROM loan WHERE user_id=?";
        return jdbcTemplate.query(getLoanByUserSql, new LoanRowMapper(),user_id);
    }
    public List<Loan> getLoansBetweenDates(LocalDate startDate, LocalDate endDate) {
        String sql = "SELECT id, user_id, copy_id, status_loan_id, loan_date, return_date, expiration_date " +
                "FROM loan WHERE loan_date BETWEEN ? AND ?";
        // Ejecutamos la consulta y devolvemos los resultados mapeados a objetos Loan
        return jdbcTemplate.query(sql, new LoanRowMapper(), Date.valueOf(startDate), Date.valueOf(endDate));
    }
}
