package com.microservice.accounts.Service;

import com.microservice.accounts.Repository.AccountRepository;
import com.microservice.accounts.Repository.CustomerRepository;
import com.microservice.accounts.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccuntService {

   private AccountRepository accountRepository;
   private CustomerRepository customerRepository;
    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
