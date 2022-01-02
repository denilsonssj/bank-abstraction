package br.com.bank.entitiy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class Bank implements Ibank {
    
    private UUID id;

    private String name;

    private List<Account> accounts;

    private Set<Customer> customers;

    public Bank(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.accounts = new ArrayList<>();
        this.customers= new HashSet<>();
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }

    @Override
    public List<Account> listAllAccounts() {
        return this.getAccounts();
    }

    @Override
    public void printAllAccounts() {
        this.accounts.stream().forEach(System.out::println);
    }

    @Override
    public Optional<Account> findAccountById(UUID id) {
        Optional<Account> account = this.getAccounts()
            .stream()
            .filter((a) -> a.getId() == id)
            .findFirst();
        return account;
    }

    @Override
    public Optional<Account> findAccountByNumber(Long number) {
        Optional<Account> account = this.getAccounts()
            .stream()
            .filter((a) -> a.getNumber() == number)
            .findFirst();
        return account;
    }

    @Override
    public void addAccount(Account account) {
       this.getAccounts().add(account);        
    }

    @Override
    public void addCustomer(Customer customer) {
        this.getCustomers().add(customer);
    }

    @Override
    public String toString() {
        return String.format("Bank{id=%s, name=%s}", this.id, this.name);
    }

}
