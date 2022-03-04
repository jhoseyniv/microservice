package com.example.bankmanagementservice.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private Environment environment;

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/getCustomerInfo/fName/{fName}")
    public Customer getCustomerInfo  (@PathVariable String fName){
        Customer bankCustomer =  repository.findCustomerByFirstName(fName);
        return bankCustomer;
    }
    @GetMapping("/checkByPINCode/pin/{pin}")
    public Customer checkByPINCode  (@PathVariable String pin){
        Customer bankCustomer =  repository.findCustomerByFirstName(pin);
        return bankCustomer;
    }


}
