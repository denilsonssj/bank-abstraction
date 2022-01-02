package br.com.bank.entitiy;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Ibank {
    
    public void printAllAccounts();

    public void addAccount(Account account);

    public void addCustomer(Customer customer);

    public List<Account> listAllAccounts();

    Optional<Account> findAccountById(UUID id);

    Optional<Account> findAccountByNumber(Long number);

}
