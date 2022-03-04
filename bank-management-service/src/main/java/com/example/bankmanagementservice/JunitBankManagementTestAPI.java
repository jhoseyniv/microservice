package com.example.bankmanagementservice;

import org.junit.Test;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JunitBankManagementTestAPI {

    @Value("${server.port}")
    private String port;
    private String server="http://localhost:"+port;
    String getRequestBody(String accNo){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity resp = restTemplate.getForEntity(server+"/getAccountInfo/accNo/"+ accNo,String.class);
        return  resp.getBody().toString();
    }
    @TestFactory
    Iterator<DynamicTest> dynamicTestgetAccountInfo(){
        String expected_accNo1="[{\"id\":1,\"accountNo\":\"Acc_1\",\"cardNo\":\"1000\",\"cvvCard\":101,\"expireDateCard\":20240404,\"initialDate\":20210402,\"balance\":100000000.00,\"status\":1}]";
        String expected_accNo2="[{\"id\":2,\"accountNo\":\"Acc_2\",\"cardNo\":\"2000\",\"cvvCard\":101,\"expireDateCard\":20240404,\"initialDate\":20210402,\"balance\":200000000.00,\"status\":1}]";
        String expected_accNo3="[{\"id\":3,\"accountNo\":\"Acc_3\",\"cardNo\":\"3000\",\"cvvCard\":201,\"expireDateCard\":20240404,\"initialDate\":20210402,\"balance\":300000000.00,\"status\":1}]";

        return Arrays.asList(
                dynamicTest("1th dynamic test", () -> assertEquals(expected_accNo1,getRequestBody("Acc_1"))),
                dynamicTest("2th dynamic test", () -> assertEquals(expected_accNo2,getRequestBody("Acc_2"))),
                dynamicTest("3th dynamic test", () -> assertEquals(expected_accNo3,getRequestBody("Acc_3"))),
                dynamicTest("4th dynamic test", () -> assertEquals("",getRequestBody("Acc_4"))),
                dynamicTest("5th dynamic test", () -> assertEquals("",getRequestBody("Acc_5")))
        ).iterator();
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
     public void failsIfExecutionTimeExceeds100Milliseconds() {
        // fails if execution time exceeds 100 milliseconds
        getRequestBody("Acc_1");
    }

}
