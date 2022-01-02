package br.com.bank.entitiy;

public class CheckingAccount extends Account {

    private static String DEFAULT_AGENCY = "0000-1";
    private static Long SEQUENTIAL = 1L;
    private static final String TYPE_ACCOUNT = "Checking account";

    public CheckingAccount(Bank bank,Customer customer) {
        super(bank, customer, TYPE_ACCOUNT);
        super.agency = DEFAULT_AGENCY;
        super.number = SEQUENTIAL++;
    }

    @Override
    public void printStatusAccount() {
        System.out.println("=== Checking Account ===");
        super.printAtributesAccounts();
    }
    
}
