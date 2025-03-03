package com.library.service;
import com.library.model.Loan;
import com.library.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private CopyService copyService;
    private static final Long LOAN_ACTIVE_STATUS_ID=1L;
    private static final Long STATUS_COPY_ID=2L;

    public Loan loanBook (Loan loan){
        Date loanDate = Date.valueOf(LocalDate.now());
        LocalDate localLoanDate = loanDate.toLocalDate();
        LocalDate expirationLocalDate = localLoanDate.plusDays(15);
        loan.setStatus_loan_id(LOAN_ACTIVE_STATUS_ID);
        loan.setLoan_date(localLoanDate);
        loan.setExpiration_date(expirationLocalDate);
        Long loanId= loanRepository.loanBook(loan.getUser_id(), loan.getCopy_id(),loan.getStatus_loan_id(), localLoanDate, expirationLocalDate);
        loan.setId(loanId);
        copyService.changeStatus(loan.getCopy_id(), STATUS_COPY_ID);
        return loan;
    }

    public void returnBook (Long loan_id, LocalDate return_date){
      loanRepository.returnBook(loan_id, return_date);
        copyService.changeStatus(loan.getCopy_id(), LOAN_ACTIVE_STATUS_ID);
    }
}
