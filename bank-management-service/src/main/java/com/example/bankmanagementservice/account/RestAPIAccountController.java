package com.example.bankmanagementservice.account;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeoutException;
import static net.logstash.logback.argument.StructuredArguments.keyValue;

@RestController
public class RestAPIAccountController {
    @Autowired
    private Environment environment;

    @Autowired
    private  AccountService accountService;

    private static final Logger logger = LoggerFactory.getLogger(RestAPIAccountController.class);

    @RolesAllowed({ "USER" })
    @GetMapping("/getAccountBalance/accNo/{accNo}")
    public String getAccountBalance (@PathVariable String accNo){
        Account bankAccount = accountService.findAccountByAccountNo(accNo);
        return bankAccount.getBalance().toString();
    }

    @GetMapping("/checkCardValidation/cardNo/{cardNo}")
    public String checkCardValidation (@PathVariable String cardNo){
        Account bankAccount = accountService.findAccountByCardNo(cardNo);
        int status = accountService.checkCardValidation(bankAccount.getCardNo());
        if(status== 0)  return "select an autentication method -->> 1)Pin Code , 2)Finger Print   3)Others ";
        return  "Your Card is Invalid ...contact with bank...";
    }

    @RolesAllowed("ADMIN")
    @Transactional(rollbackFor = { SQLException.class })
    @GetMapping("/withDraw/from/{accNo}/{value}")
    public String withdrawalMoney (@PathVariable String accNo,@PathVariable BigDecimal value) throws SQLException{
        Account bankAccount = accountService.findAccountByAccountNo(accNo);
        logger.info("{withdrawal Money}", keyValue("accNo", accNo));
        BigDecimal reminder= bankAccount.getBalance().subtract(value);
        bankAccount.setBalance(reminder);
        accountService.saveAndFlush(bankAccount);
         //throw new SQLException("Throwing exception for WithDraw Money rollback");
        return "Money Withdraw successfull from "+ bankAccount.getAccountNo();
    }

    @CircuitBreaker(name = "bank-management-service")
    @RequestMapping(value = "/getAccountInfo/accNo/{accNo}", produces = "application/json")
    @ResponseBody
    public List<Account> getAccountInfo(@PathVariable String accNo) {
        randomlyRunLong();

        //save log in Transaction Table...
        logger.info("getAccountInfo}", keyValue("accNo", accNo));

        Account bankAccount = accountService.findAccountByAccountNo(accNo);
        List<Account> employees = new ArrayList<>();
        employees.add(bankAccount);
        return employees;

    }
    private void randomlyRunLong(){
        Random rand = new Random();
        int randomNum = rand.nextInt(3) + 1;
        if (randomNum==3) sleep();
    }
    private void sleep(){
        try {
            Thread.sleep(5000);
            throw new java.util.concurrent.TimeoutException();
        } catch (InterruptedException | TimeoutException e) {
           System.out.println("I am Here...............................");
        }
    }
}
