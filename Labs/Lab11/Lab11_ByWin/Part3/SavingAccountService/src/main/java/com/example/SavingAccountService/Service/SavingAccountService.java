package com.example.SavingAccountService.Service;

import com.example.SavingAccountService.Data.Account;
import com.example.SavingAccountService.Repository.SavingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingAccountService {
    @Autowired
    SavingAccountRepository savingAccountRepository;

    public void deposit(int accountNumber, double amount) {
        Account account = savingAccountRepository.findById(accountNumber);
        account.deposit(amount);
    }

    public boolean withdraw(int accountNumber, double amount) {
        Account account = savingAccountRepository.findById(accountNumber);
        return account.withdraw(amount);
    }

    public double getBalance(int accountNumber) {
        Account account = savingAccountRepository.findById(accountNumber);
        return account.getBalance();
    }

    public void createAccount(Account account) {
        savingAccountRepository.save(account);
    }

    public Account getAccount(int accountNumber) {
        return savingAccountRepository.findById(accountNumber);
    }
}
