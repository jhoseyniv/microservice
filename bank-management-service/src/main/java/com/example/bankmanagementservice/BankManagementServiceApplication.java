package com.example.bankmanagementservice;

import com.example.bankmanagementservice.account.Account;
import com.example.bankmanagementservice.account.AccountRepository;
import com.example.bankmanagementservice.customer.Customer;
import com.example.bankmanagementservice.customer.CustomerRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@EnableDiscoveryClient
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Bank API", version = "2.0", description = "Bank Management Information"))
public class BankManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankManagementServiceApplication.class, args);
	}
	private static final Logger log = LoggerFactory.getLogger(BankManagementServiceApplication.class);

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			;
			log.info("Start Application...ATM Emulator .....");
			System.out.println("Let's inspect the beans provided by Spring Boot:");

			Customer customer_1 =new Customer(1L,1L,"customer_1","hosseini",19780909,1,"12345","finger_print 1");
			Customer customer_2 =new Customer(2L,2L,"customer_2","hosseini",20000202,1,"12345","finger_print 2");
			Customer customer_3 =new Customer(3L,3L,"customer_3","hosseini",19701210,1,"12345","finger_print 3");
			Customer customer_4 =new Customer(4L,4L,"customer_4","hosseini",19960612,1,"12345","finger_print 4");
			Customer customer_5 =new Customer(5L,5L,"customer_5","hosseini",19851009,1,"12345","finger_print 5");
			customerRepository.save(customer_1);
			customerRepository.save(customer_2);
			customerRepository.save(customer_3);
			customerRepository.save(customer_4);
			customerRepository.save(customer_5);



			Account bankAccount_1=new Account(1L,"Acc_1","1000",101,20240404,20210402,new BigDecimal(100000000),1,customer_1);
			Account bankAccount_2=new Account(2L,"Acc_2","2000",101,20240404,20210402,new BigDecimal(200000000),1,customer_1);
			Account bankAccount_3=new Account(3L,"Acc_3","3000",201,20240404,20210402,new BigDecimal(300000000),1,customer_2);
			Account bankAccount_4=new Account(4L,"Acc_4","4000",301,20240404,20210402,new BigDecimal(400000000),1,customer_3);
			Account bankAccount_5=new Account(5L,"Acc_5","5000",401,20240404,20210402,new BigDecimal(500000000),1,customer_4);
			accountRepository.save(bankAccount_1);
			accountRepository.save(bankAccount_2);
			accountRepository.save(bankAccount_3);
			accountRepository.save(bankAccount_4);
			accountRepository.save(bankAccount_5);
		};
	}

}
