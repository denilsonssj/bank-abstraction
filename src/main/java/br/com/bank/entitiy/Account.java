package br.com.bank.entitiy;

import java.math.BigDecimal;
import java.util.UUID;

public abstract class Account implements IAccount {

    private UUID id;
    
    protected String agency;

    protected Long number;

    protected BigDecimal balance;

    protected String type;

    private Customer customer;

    private Bank bank;

    public Account(Bank bank, Customer customer, String type) {
        this.id = UUID.randomUUID();
        this.bank = bank;
        this.balance = BigDecimal.ZERO;
        this.customer = customer;
        this.type = type;

        this.getBank().addAccount(this);
        this.getBank().addCustomer(this.getCustomer());
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAgency() {
        return this.agency;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public Long getNumber() {
        return this.number;
    }

    public String getType() {
        return this.type;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Bank getBank() {
        return this.bank;
    }

    @Override
    public void deposit(BigDecimal value) {
       this.balance = this.balance.add(value);
    }

    @Override
    public void withDrawn(BigDecimal value) {
        try {
            BigDecimal balanceAfterWithDrawn = this.balance.subtract(value);
            if (balanceAfterWithDrawn.compareTo(BigDecimal.ZERO) >= 0) {
                this.balance = balanceAfterWithDrawn;
            }
            else {
                throw new RuntimeException("Error operation: Balance account after withdrawn is less then zero.");
            }
        } catch(RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void transfer(BigDecimal value, Account accountDestination) {
        this.withDrawn(value);
        accountDestination.deposit(value);
    }

    protected String getFormatedAtributesAccounts() {
        String message = String.format("Bank's name: \"%s\"\nAgency: \"%s\"\nNumber: \"%s\"\nBalance: $%.2f",
            this.bank.getName(), this.agency, this.number, this.balance);
        return message;
    }

    protected void printAtributesAccounts() {
        String message = this.getFormatedAtributesAccounts();
        System.out.println(message);
    }

    @Override
    public String toString() {
        return String.format("Account{id=\"%s\", agency=\"%s\", type=\"%s\", number=%s, customerId=\"%s\", bankName=\"%s\"}",
            this.id, this.agency, this.type, this.number, this.customer.getId(), this.bank.getName());
    }

}
