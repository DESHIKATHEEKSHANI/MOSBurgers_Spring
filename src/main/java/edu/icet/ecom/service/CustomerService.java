package edu.icet.ecom.service;

import edu.icet.ecom.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO addCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAll();
    void deleteCustomer(Long id);
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    CustomerDTO searchById(Long id);
    List<CustomerDTO> searchByName(String name);
    List<CustomerDTO> searchByContact(String contact);
}
