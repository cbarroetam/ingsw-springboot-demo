package cdbm.ucab.ingsw.controller;

import cdbm.ucab.ingsw.command.CustomerSignUpCommand;
import cdbm.ucab.ingsw.response.CustomerResponse;
import cdbm.ucab.ingsw.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value="/customer", produces = "application/json")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "", consumes = "application/json", method = RequestMethod.POST)
    public ResponseEntity register(@Valid @RequestBody CustomerSignUpCommand command) {

        boolean result = customerService.register(command);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public ResponseEntity<List<CustomerResponse>> getCustomersByEmail(@PathVariable("email") String email) {

        ArrayList<CustomerResponse> response = new ArrayList<>();
        customerService.findCustomersByEmail(email).forEach(it ->{
            CustomerResponse customerResponse = new CustomerResponse();
            customerResponse.setFirstName(it.getFirstName());
            customerResponse.setLastName(it.getLastName());
            customerResponse.setEmail(it.getEmail());
            customerResponse.setId(it.getUuid());

            response.add(customerResponse);
        });

        return ResponseEntity.ok(response);
    }
}
