package edu.icet.crm.service;

import edu.icet.crm.dto.Customer;

public interface CustomerService {
    Customer save(Customer customer);

    void deleteCustomer(Integer Id);

    void updateCustomer(Customer customer);
}
