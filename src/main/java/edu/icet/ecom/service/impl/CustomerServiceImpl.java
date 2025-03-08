package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.CustomerDTO;
import edu.icet.ecom.entity.Customer;
import edu.icet.ecom.repository.CustomerRepository;
import edu.icet.ecom.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customerRepository.save(customer);
        return customerDTO;
    }

    @Override
    public List<CustomerDTO> getAll() {
        return customerRepository.findAll().stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customerRepository.save(customer);
        return customerDTO;
    }

    @Override
    public CustomerDTO searchById(Long id) {
        return customerRepository.findById(id)
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .orElse(null);
    }

    @Override
    public List<CustomerDTO> searchByName(String name) {
        return customerRepository.findByName(name).stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> searchByContact(String contact) {
        return customerRepository.findByContact(contact).stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }
}
