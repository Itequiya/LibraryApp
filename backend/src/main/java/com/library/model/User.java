package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private Long id;
    private Long role_id;
    private String name ;
    private String lastname;
    private String mail;
    private String  phone;
}
