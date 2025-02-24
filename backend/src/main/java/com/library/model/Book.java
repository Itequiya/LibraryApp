package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    private Long id;
    private String title;
    private Long library_id ;
    private String author;
    private int pages;
    private String  editorial;
}
