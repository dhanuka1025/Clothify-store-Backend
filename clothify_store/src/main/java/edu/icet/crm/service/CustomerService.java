package edu.icet.crm.service;

import edu.icet.crm.model.User;

public interface CustomerService {
    User save(User user);

    void deleteCustomer(Integer Id);

    void updateCustomer(User user);
}
