package com.library.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Loan
{
    private Long id;
    @NotNull
    private Long user_id;
    @NotNull
    private Long copy_id;
    private Long status_loan_id;
    private LocalDate loan_date;
    private LocalDate return_date;
    private LocalDate expiration_date;
}
