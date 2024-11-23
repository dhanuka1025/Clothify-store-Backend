package edu.icet.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.dto.Customer;
import edu.icet.crm.entity.CustomerEntity;
import edu.icet.crm.repository.CustomerRepository;
import edu.icet.crm.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ObjectMapper mapper;
    @Override
    public Customer save(Customer customer) {
        return mapper.convertValue(customerRepository.save(mapper.convertValue(customer, CustomerEntity.class)), Customer.class);
    }

    @Override
    public void deleteCustomer(Integer Id) {
        customerRepository.deleteById(Id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(mapper.convertValue(customer, CustomerEntity.class));
    }
}
