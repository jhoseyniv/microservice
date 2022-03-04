package com.example.atmmanagementservice.account;

import com.example.atmmanagementservice.config.ATMServiceProxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestAccountController {

    @Autowired
    private ATMServiceProxy proxy;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(RestAccountController.class);

    @RequestMapping(value = "/getAccountInfo/accNo/{accNo}")
    public AccountBean getAccountInfo(@PathVariable String accNo) throws URISyntaxException {
        List<ServiceInstance> instances = discoveryClient.getInstances("bank-management-service");
        if (instances.size()==0) return null;
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("accNo", accNo);
        String  url= instances.get(0).getUri().toString()+"/getAccountInfo/accNo/{accNo}";
        ResponseEntity<AccountBean[]> responseEntity = new RestTemplate().exchange(url, HttpMethod.GET,null,AccountBean[].class, uriVariables);

        AccountBean[] response = responseEntity.getBody();
         AccountBean accountBean =response[0];
            return new AccountBean(accountBean.getId(), accNo, accountBean.getCardNo(), accountBean.getCvvCard(),accountBean.getExpireDateCard(), accountBean.getInitialDate(),accountBean.getInitialDate(),accountBean.getBalance(),accountBean.getStatus());
    }

    @GetMapping("/getAccountInfo-feign/accNo/{accNo}")
    public AccountBean convertCurrencyFeign(@PathVariable String accNo) {
        AccountBean[] response = proxy.getAccountDetail(accNo);
        AccountBean accountBean =response[0];
        return new AccountBean(accountBean.getId(), accNo, accountBean.getCardNo(), accountBean.getCvvCard(),accountBean.getExpireDateCard(), accountBean.getInitialDate(),accountBean.getInitialDate(),accountBean.getBalance(),accountBean.getStatus());
    }
    @GetMapping("/getSeriveInfo/accNo/{accNo}")
    public String getSeriveInfo(@PathVariable String accNo) {
        return "Hello " + accNo;
    }

    @RequestMapping(value = "/getAccountBalance/accNo/{accNo}")
    public String getAccountBalance(@PathVariable String accNo) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("accNo", accNo);
        String  url= "http://bank-management-service/getAccountBalance/accNo/{accNo}";
        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(url,String.class, uriVariables);
        return responseEntity.getBody();
    }
//    @RequestMapping(value = "/getAccountBalance/accNo/{accNo}")
//    public String getAccountBalance(@PathVariable String accNo) {
//        List<ServiceInstance> instances = discoveryClient.getInstances("bank-management-service");
//        if (instances.size()==0) return null;
//        Map<String, String> uriVariables = new HashMap<>();
//        uriVariables.put("accNo", accNo);
//        String  url= instances.get(0).getUri().toString()+"/getAccountBalance/accNo/{accNo}";
//        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(url,String.class, uriVariables);
//        return responseEntity.getBody();
//    }

    @RequestMapping(value = "/withDraw/from/{accNo}/{value}")
    public String withdrawalMoney(@PathVariable String accNo,@PathVariable BigDecimal value) {
        List<ServiceInstance> instances = discoveryClient.getInstances("bank-management-service");
        if (instances.size()==0) return null;
        String  url= instances.get(0).getUri().toString()+"/withDraw/from/"+accNo + "/" + value;

        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(url, String.class);
        return responseEntity.getBody();
    }


}
