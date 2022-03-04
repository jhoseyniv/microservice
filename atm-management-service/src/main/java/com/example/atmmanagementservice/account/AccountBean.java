package com.example.atmmanagementservice.account;

import java.math.BigDecimal;

public class AccountBean {
    private Long id;
    private String accountNo;
    private String cardNo;
    private Long cvvCard;
    private Long expireDateCard;
    private Long initialDate;
    private BigDecimal balance;
    private Long status;

    public AccountBean() {
    }

    public AccountBean(Long id, String accountNo, String cardNo, long cvvCard, long expireDateCard, long initialDate, long initialDate1, BigDecimal balance, long status) {
        this.id = id;
        this.accountNo = accountNo;
        this.cardNo = cardNo;
        this.cvvCard = cvvCard;
        this.expireDateCard = expireDateCard;
        this.initialDate = initialDate;
        this.balance = balance;
        this.status = status;
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

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", accountNo=" + accountNo +" , cardNo= " + cardNo + " , cvvCard="+ cvvCard + ",expireDateCard="+expireDateCard + "]";
    }

}
