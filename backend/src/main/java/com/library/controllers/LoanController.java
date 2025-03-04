package com.library.controllers;
import com.library.model.Loan;
import com.library.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/loan")

public class LoanController {
    @Autowired
    private LoanService loanService;

    @PostMapping("/newLoan")
    public Loan newLoan (@Valid @RequestBody Loan loan){
        return loanService.loanBook(loan);
    }

    @PatchMapping ("/finishLoan")
    public String finishLoan (@RequestParam ("loanId")Long loanId, @RequestParam ("returnDate") LocalDate return_date){
        loanService.finishLoan(loanId, return_date);
        return "Loan finished";
    }
    @GetMapping("/getLoansByUser")
    public List<Loan> getLoansByUser(@RequestParam("userId") Long user_id){
        return loanService.getLoanByUser(user_id);
    }
    @GetMapping("/getLoansBetweenDates")
    public List<Loan> getLoansBetweenDates(@RequestParam("startDate") LocalDate startDate,
                                           @RequestParam("endDate") LocalDate endDate) {
        return loanService.getLoansBetweenDates(startDate, endDate);
    }
}
