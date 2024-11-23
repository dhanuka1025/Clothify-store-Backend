package edu.icet.crm.dto;

import lombok.Data;

@Data
public class Customer {
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String address;
}
