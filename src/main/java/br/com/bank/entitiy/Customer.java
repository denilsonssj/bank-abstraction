package br.com.bank.entitiy;

import java.util.UUID;

public class Customer {
    
    private UUID id;

    private String fullName;

    public Customer(String fullName) {
        this.id = UUID.randomUUID();
        this.fullName = fullName;
    }

    public UUID getId() {
        return id;
    }

    public String getfullName() {
        return fullName;
    }

    public void setfullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return String.format("Customer{id = \"%s\", fullName=\"%s\"}", this.id, this.fullName);
    }

}
