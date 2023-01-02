package com.example.CheckingAccountService.Web;

import com.example.CheckingAccountService.Data.Account;
import com.example.CheckingAccountService.Service.CheckingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CheckingAccountController {
        @Autowired
        CheckingAccountService checkingAccountService;

        @PostMapping("/checking")
        public ResponseEntity<?> createCheckingAccount(@RequestBody Account checkingAccount) {
            checkingAccountService.createAccount(checkingAccount);
            System.out.println("Successfully created an checking account");
            return new ResponseEntity(HttpStatus.OK);
        }

        @GetMapping("/checking/{accountNumber}")
        public Account getAccount(@PathVariable int accountNumber) {
            return checkingAccountService.getAccount(accountNumber);
        }

        @PostMapping("/deposit")
        public ResponseEntity<?> deposit(@RequestParam ("accountNumber") int accountNumber, @RequestParam ("amount") double amount) {
            checkingAccountService.deposit(accountNumber, amount);
            return new ResponseEntity(HttpStatus.OK);
        }

        @PostMapping("/withdraw")
        public ResponseEntity<?> withDraw(@RequestParam ("accountNumber") int accountNumber, @RequestParam ("amount") double amount) {
            boolean result = checkingAccountService.withdraw(accountNumber, amount);
            if (result)
                return new ResponseEntity("Successfully withdraw", HttpStatus.OK);
            else
                return new ResponseEntity("Failed, no enough balance", HttpStatus.OK);
        }
}
