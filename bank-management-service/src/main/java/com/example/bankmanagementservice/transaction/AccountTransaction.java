package com.example.bankmanagementservice.transaction;

import com.example.bankmanagementservice.account.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class AccountTransaction {
      @Id
      private Long id;

      @ManyToOne(fetch = FetchType.LAZY, optional = false)
      @JoinColumn(name = "account_id", nullable = false)
      @JsonIgnore
      private Account account;

      private Long transactionStatus;  // task complete | task not complete roll back...
      private Long transactionDate;
      private Long transactionType;    // login/logout/block card/ withdraw /deposit / transfer/ balance / etc...

}
