package com.microservice.accounts.dto;

import jakarta.persistence.Column;

import lombok.Data;

@Data
public class AccountDto {

    @Column(name = "account_number")
    private Long accountNumber;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "branch_address")
    private String branchAddress;
}
