package com.microservice.accounts.Service;

import com.microservice.accounts.Constants.AccountConstants;
import com.microservice.accounts.Entity.Account;
import com.microservice.accounts.Entity.Customer;
import com.microservice.accounts.Exception.CustomerAlreadyExistsExceptions;
import com.microservice.accounts.Mapper.CustomerMapper;
import com.microservice.accounts.Repository.AccountRepository;
import com.microservice.accounts.Repository.CustomerRepository;
import com.microservice.accounts.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service

@AllArgsConstructor
public class AccountServiceImpl implements AccuntService {

   private final AccountRepository accountRepository;
   private  final CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto,new Customer());
        Optional<Customer> optionalCustomer =  customerRepository.findByMobileNumber(customer.getMobileNumber());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsExceptions("Customer already exists with given mobileNumber"+ customerDto.getMobileNumber());
        }
          customer.setCreatedAt(LocalDateTime.now());
          customer.setCreatedBy("Anonymous");
       Customer savedCustomer =  customerRepository.save(customer);
       accountRepository.save(createNewAccount(savedCustomer));
    }

    private Account createNewAccount(Customer customer) {
        Account newAccount = new Account();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextLong(900000000);
        newAccount.setAccountNumber(String.valueOf(randomAccNumber));
        newAccount.setAccountType(AccountConstants.SAVING);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");
        return newAccount;
    }

}
