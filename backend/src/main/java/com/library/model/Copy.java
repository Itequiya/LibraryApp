package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Copy {
    private Long id;
    private Long book_id;
    private Long status_copy_id;
}
