package pl.emil7f.account;

import java.util.List;

public interface AccountRepository {

    List<Account> getAllAccounts();
    List<String> getByName(String name);
}
