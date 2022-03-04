package com.example.bankmanagementservice.account;

import com.example.bankmanagementservice.transaction.AccountTransaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.bankmanagementservice.customer.Customer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;
//import lomobk.*;

@Entity
public class Account {

    @Id
    private Long id;

    @Column(name="Account_NO")
    private String accountNo;

    @Column(name="CARD_NO")
    private String cardNo;

    @Column(name="CVV_CARD")
    private long cvvCard;

    @Column(name="ExpireDate_Card")
    private long expireDateCard;

    @Column(name="Initial_Date")
    private long initialDate;

    private BigDecimal balance;

    private int status;

    public Account() {

    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private Customer customer;


    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<AccountTransaction> accountTransactions;


    public Account(Long id, String accountNo,String cardNo,long cvvCard,long expireDateCard, long initialDate, BigDecimal balance, int status,Customer customer) {
        this.id = id;
        this.accountNo = accountNo;
        this.cardNo = cardNo;
        this.cvvCard = cvvCard;
        this.expireDateCard = expireDateCard;
        this.initialDate = initialDate;
        this.balance = balance;
        this.status = status;
        this.customer =customer;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public long getCvvCard() {
        return cvvCard;
    }

    public void setCvvCard(long cvvCard) {
        this.cvvCard = cvvCard;
    }

    public long getExpireDateCard() {
        return expireDateCard;
    }

    public void setExpireDateCard(long expireDateCard) {
        this.expireDateCard = expireDateCard;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public long getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(long initialDate) {
        this.initialDate = initialDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
