package br.com.bank.entitiy;

public class SavingsAccount extends Account {

    private static Long SEQUENTIAL = 1L;
    private static String DEFAULT_AGENCY = "0000-0";
    private static final String TYPE_ACCOUNT = "SavingsAccount account";

    public SavingsAccount(Bank bank, Customer customer) {
        super(bank, customer, TYPE_ACCOUNT);
        super.agency = DEFAULT_AGENCY;
        super.number = SEQUENTIAL++;
    }

    @Override
    public void printStatusAccount() {
        System.out.println("=== Savings Account ===");
        super.printAtributesAccounts();
        System.out.println("=======================");
    }
    
}
