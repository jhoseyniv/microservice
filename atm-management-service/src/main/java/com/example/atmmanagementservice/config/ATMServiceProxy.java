package com.example.atmmanagementservice.config;

import com.example.atmmanagementservice.account.AccountBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="bank-management-service" ,configuration = OpenFeignConfiguration.class)

@Component
public interface ATMServiceProxy {
    @GetMapping("/getAccountInfo/accNo/{accNo}")
    public AccountBean[] getAccountDetail(@PathVariable("accNo") String accNo);
}