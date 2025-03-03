package com.library.controllers;
import com.library.model.Loan;
import com.library.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/loan")

public class LoanController {
    @Autowired
    private LoanService loanService;

    @PostMapping("/newLoan")
    public Loan newLoan (@Valid @RequestBody Loan loan){
        return loanService.loanBook(loan);
    }

    @PatchMapping ("/returnLoan")
    public String returnLoan (@RequestParam Long loanId, LocalDate return_date){
        loanService.returnBook(loanId, return_date);
        return "Return register complete";
    }


}
