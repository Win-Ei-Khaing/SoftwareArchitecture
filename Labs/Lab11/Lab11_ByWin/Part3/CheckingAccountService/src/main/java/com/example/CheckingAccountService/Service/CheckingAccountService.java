package com.example.CheckingAccountService.Service;

import com.example.CheckingAccountService.Data.Account;
import com.example.CheckingAccountService.Repository.CheckingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckingAccountService {
    @Autowired
    CheckingAccountRepository checkingAccountRepository;

    public void deposit(int accountNumber, double amount) {
        Account account = checkingAccountRepository.findById(accountNumber);
        account.deposit(amount);
    }

    public boolean withdraw(int accountNumber, double amount) {
        Account account = checkingAccountRepository.findById(accountNumber);
        return account.withdraw(amount);
    }

    public double getBalance(int accountNumber) {
        Account account = checkingAccountRepository.findById(accountNumber);
        return account.getBalance();
    }

    public void createAccount(Account account) {
        checkingAccountRepository.save(account);
    }

    public Account getAccount(int accountNumber) {
        return checkingAccountRepository.findById(accountNumber);
    }
}
