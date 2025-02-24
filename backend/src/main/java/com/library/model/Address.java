package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private Long id;
    private String country;
    private String city;
    private String state;
    private String street;
    private String zipCode;
}
