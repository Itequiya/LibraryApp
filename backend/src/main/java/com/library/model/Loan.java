package com.library.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Loan
{
    private Long id;
    private Long user_id;
    private Long copy_id;
    private Long status_loan_id;
    private Date loan_date;
    private Date return_date;
    private Date expiration_date;
}
