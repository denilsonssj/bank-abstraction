package br.com.bank.entitiy;

import java.math.BigDecimal;

public interface IAccount {
    
    void withDrawn(BigDecimal value);
    void deposit(BigDecimal value);
    void transfer(BigDecimal value, Account accountDestination);
    void printStatusAccount();

}
