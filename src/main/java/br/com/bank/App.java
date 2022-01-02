package br.com.bank;

import java.math.BigDecimal;
import java.util.Optional;

import br.com.bank.entitiy.Account;
import br.com.bank.entitiy.Bank;
import br.com.bank.entitiy.CheckingAccount;
import br.com.bank.entitiy.Customer;
import br.com.bank.entitiy.SavingsAccount;

public class App 
{
    public static void main( String[] args ) {
        Bank bank = new Bank("Hue Hue Bank");
        Customer customerOne = new Customer("Joe Doe");
        Account checkingAccount =  new CheckingAccount(bank, customerOne);
        Account savingsAccount = new SavingsAccount(bank, customerOne);

        Customer customerTwo = new Customer("Mary Johnson");
        Account savingsAccountTwo = new SavingsAccount(bank, customerTwo);

        savingsAccount.deposit(BigDecimal.valueOf(5000));

        savingsAccount.printStatusAccount();
        checkingAccount.printStatusAccount();

        savingsAccount.transfer(BigDecimal.valueOf(1200), checkingAccount);
        checkingAccount.printStatusAccount();
        
        // Send $ 600 from joe's saving account to mary's saving account
        savingsAccount.transfer(BigDecimal.valueOf(600), savingsAccountTwo);
        savingsAccount.printStatusAccount();

        Optional<Account> accountFinded = bank.findAccountByNumber(1L)
            .stream()
            .findFirst();
        if (accountFinded.isPresent()) {
            Account a = accountFinded.get();
            System.out.println(a);
        }
    }
}
