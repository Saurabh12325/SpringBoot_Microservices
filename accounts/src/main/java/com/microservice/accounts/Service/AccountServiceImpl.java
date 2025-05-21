package com.microservice.accounts.Service;

import com.microservice.accounts.Constants.AccountConstants;
import com.microservice.accounts.Entity.Account;
import com.microservice.accounts.Entity.Customer;
import com.microservice.accounts.Mapper.CustomerMapper;
import com.microservice.accounts.Repository.AccountRepository;
import com.microservice.accounts.Repository.CustomerRepository;
import com.microservice.accounts.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccuntService {

   private AccountRepository accountRepository;
   private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
       Customer customer = CustomerMapper.mapToCustomer(customerDto,new Customer());
       Customer savedCustomer =  customerRepository.save(customer);
       accountRepository.save(createNewAcount(savedCustomer));
    }

    private Account createNewAcount(Customer customer) {
        Account newAccount = new Account();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextLong(900000000);
        newAccount.setAccountNumber(String.valueOf(randomAccNumber));
        newAccount.setAccountType(AccountConstants.SAVING);
        return newAccount;
    }


}
