package org.champsoft.clothingstoreapp.businessLogicLayer;

import org.champsoft.clothingstoreapp.dataAccessLayer.Customer;
import org.champsoft.clothingstoreapp.dataAccessLayer.CustomerRepository;
import org.champsoft.clothingstoreapp.dataMapperLayer.CustomerResponseMapper;
import org.champsoft.clothingstoreapp.presentationLayer.CustomerResponseModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;
    private final CustomerResponseMapper customerResponseMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerResponseMapper customerResponseMapper) {
        this.customerRepository = customerRepository;
        this.customerResponseMapper = customerResponseMapper;
    }

    @Override
    public List<CustomerResponseModel> getCustomers() {
        List<Customer> customers = this.customerRepository.findAll();
        return this.customerResponseMapper.entityListToResponseModelList(customers);
    }
}
