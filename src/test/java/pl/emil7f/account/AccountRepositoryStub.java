package pl.emil7f.account;

import java.util.Arrays;
import java.util.List;

public class AccountRepositoryStub implements AccountRepository {

    /**
     *          Stub example
     *
     */
    @Override
    public List<Account> getAllAccounts() {
        Address address1 = new Address("Ulica", "13");
        Address address2 = new Address("Ulica", "13");
        Account account = new Account(address1);
        Account account2 = new Account(address2);
        Account account3 = new Account();
        return Arrays.asList(account, account2, account3);
    }
}
