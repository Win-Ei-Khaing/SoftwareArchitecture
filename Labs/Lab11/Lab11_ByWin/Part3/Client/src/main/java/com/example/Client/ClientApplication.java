package com.example.Client;

import com.example.Client.Data.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {
	@Autowired
	private RestOperations restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Creating a saving account
		Account savingAccount = new Account(111111, "Win Ei Khaing", "wkhaing@miu.edu");
		restTemplate.postForLocation("http://localhost:8080/saving",savingAccount);

		// Deposit
		restTemplate.postForLocation("http://localhost:8080/deposit?accountNumber=111111&amount=1000", null);
		System.out.println("--------------------------------");

		// Creating a checking account
		Account checkingAccount = new Account(222222, "Welda", "welda@gmail.com");
		restTemplate.postForLocation("http://localhost:8081/checking",checkingAccount);

		// Deposit
		restTemplate.postForLocation("http://localhost:8081/deposit?accountNumber=222222&amount=2000", null);
		System.out.println("--------------------------------");

		//print accounts
		Account savingAcc = restTemplate.getForObject("http://localhost:8080/saving/111111" , Account.class);
		Account checkingAcc = restTemplate.getForObject("http://localhost:8081/checking/222222" , Account.class);
		System.out.println("Saving account: "+ savingAcc.toString());
		System.out.println("Checking account: "+ checkingAcc.toString());

		System.out.println("--------------------------------");

		System.out.println("Transfer 500 from Win Ei Khaing to Welda");
		// Deposit into account
		restTemplate.postForLocation("http://localhost:8081/deposit?accountNumber=222222&amount=500", null);
		String result= restTemplate.postForObject("http://localhost:8080/withdraw?accountNumber=111111&amount=500",null, String.class);
		if(result.equals("Failed, no enough balance: ")){
			System.out.println("compensating action: ");
			restTemplate.postForLocation("http://localhost:8081/withdraw?accountNumber=222222&amount=500", null); //compensate
		}
		//print accounts
		savingAcc = restTemplate.getForObject("http://localhost:8080/saving/111111" , Account.class);
		checkingAcc = restTemplate.getForObject("http://localhost:8081/checking/222222" , Account.class);
		System.out.println("Saving account"+ savingAcc.toString());
		System.out.println("Checking account"+ checkingAcc.toString());

		System.out.println("--------------------------------");

		System.out.println("Transfer another 1000 from Win Ei Khaing to Welda");
		// Deposit into account
		restTemplate.postForLocation("http://localhost:8081/deposit?accountNumber=222222&amount=1000", null);
		result= restTemplate.postForObject("http://localhost:8080/withdraw?accountNumber=111111&amount=1000",null, String.class);
		if(result.equals("Failed, no enough balance")){
			System.out.println("compensating action");
			restTemplate.postForLocation("http://localhost:8081/withdraw?accountNumber=222222&amount=1000", null); //compensate
		}

		//print accounts
		savingAcc = restTemplate.getForObject("http://localhost:8080/saving/111111" , Account.class);
		checkingAcc = restTemplate.getForObject("http://localhost:8081/checking/222222" , Account.class);
		System.out.println("Saving account: "+ savingAcc.toString());
		System.out.println("Checking account: "+ checkingAcc.toString());
	}

	@Bean
	RestOperations restTemplate() {
		return new RestTemplate();
	}
}
