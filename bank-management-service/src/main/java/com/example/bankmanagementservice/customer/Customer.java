package com.example.bankmanagementservice.customer;

import com.example.bankmanagementservice.account.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    private Long id;

    public Customer(Long id, Long nationalNo, String firstName, String lastName, long birthDate, int status,String pinCode,String fingerPrint) {
        this.id = id;
        this.nationalNo = nationalNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.status = status;
        this.pinCode=pinCode;
        this.fingerPrint=fingerPrint;

    }

    public Customer() {
    }

    @Column(name="National_No")
    private Long nationalNo;

    @Column(name="First_Name")
    private String firstName;

    @Column(name="Last_Name")
    private String lastName;

    @Column(name="Birth_Date")
    private long birthDate;

    @Column(name="PIN_CODE")
    private String pinCode;

    @Column(name="Finger_Print")
    private String fingerPrint;

     private int status;



    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Account> accounts;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNationalNo() {
        return nationalNo;
    }

    public void setNationalNo(Long nationalNo) {
        this.nationalNo = nationalNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
