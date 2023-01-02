package com.example.SavingAccountService.Web;

import com.example.SavingAccountService.Data.Account;
import com.example.SavingAccountService.Service.SavingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SavingAccountController {
        @Autowired
        SavingAccountService savingAccountService;

        @PostMapping("/saving")
        public ResponseEntity<?> createSavingAccount(@RequestBody Account savingAccount) {
            savingAccountService.createAccount(savingAccount);
            System.out.println("Successfully created an saving account");
            return new ResponseEntity(HttpStatus.OK);
        }

        @GetMapping("/saving/{accountNumber}")
        public Account getAccount(@PathVariable int accountNumber) {
            return savingAccountService.getAccount(accountNumber);
        }

        @PostMapping("/deposit")
        public ResponseEntity<?> deposit(@RequestParam ("accountNumber") int accountNumber, @RequestParam ("amount") double amount) {
            savingAccountService.deposit(accountNumber, amount);
            return new ResponseEntity(HttpStatus.OK);
        }

        @PostMapping("/withdraw")
        public ResponseEntity<?> withDraw(@RequestParam ("accountNumber") int accountNumber, @RequestParam ("amount") double amount) {
            boolean result = savingAccountService.withdraw(accountNumber, amount);
            if (result)
                return new ResponseEntity("Successfully withdraw", HttpStatus.OK);
            else
                return new ResponseEntity("Failed, no enough balance", HttpStatus.OK);
        }
}
