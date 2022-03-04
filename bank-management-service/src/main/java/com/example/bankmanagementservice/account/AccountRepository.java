package com.example.bankmanagementservice.account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountByAccountNo(String accountNo);
    Account findAccountByCardNo(String cardNo);
}
