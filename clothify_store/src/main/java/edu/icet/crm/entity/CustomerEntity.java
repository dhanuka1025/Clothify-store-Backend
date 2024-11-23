package edu.icet.crm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customer")
public class CustomerEntity {
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String address;
}
