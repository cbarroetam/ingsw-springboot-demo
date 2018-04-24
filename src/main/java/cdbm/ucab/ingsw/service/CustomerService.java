package cdbm.ucab.ingsw.service;

import cdbm.ucab.ingsw.command.CustomerSignUpCommand;
import cdbm.ucab.ingsw.model.Customer;
import cdbm.ucab.ingsw.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("customerService")
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    private Customer buildCustomer(CustomerSignUpCommand command) {
        Customer customer = new Customer();
        customer.setId(System.currentTimeMillis());
        customer.setFirstName(command.getFirstName());
        customer.setLastName(command.getLastName());
        customer.setEmail(command.getEmail());
        customer.setPassword(command.getPassword());

        return customer;
    }

    public boolean register(CustomerSignUpCommand command) {

        log.debug("About to process [{}]", command);

        Customer customer = buildCustomer(command);
        customer = customerRepository.save(customer);

        log.info("Registered customer with ID={}", customer.getId());
        return true;
    }

    public List<Customer> findCustomersByEmail(String email) {

        List<Customer> customers = customerRepository.findFirst3ByEmailIgnoreCaseContaining(email);

        log.info("Found {} records with the partial email address={}", customers.size(), email);
        return customers;
    }
}
