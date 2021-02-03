package pl.emil7f.account;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountServiceTest {

    @Test
        // Mock example
    void getAllActiveAccounts() {
        // given
        List<Account> accounts = prepareAccountData();
        AccountRepository accountRepository = mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepository);

        // nauka mocka when(nazwaMocka.metoda() coś sie dzieje . wtedy zwróć coś tam
       // when(accountRepository.getAllAccounts()).thenReturn(accounts);
        // lub
        given(accountRepository.getAllAccounts()).willReturn(accounts);


        // when
        List<Account> accountList = accountService.getAllActiveAccounts();
        //then
        assertThat(accountList, hasSize(2));
    }

    @Test
        // Mock example
    void getNoActiveAccounts() {
        // given
        AccountRepository accountRepository = mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepository);

        given(accountRepository.getAllAccounts()).willReturn(Collections.emptyList());


        // when
        List<Account> accountList = accountService.getAllActiveAccounts();
        //then
        assertThat(accountList, hasSize(0));
    }

    private List<Account> prepareAccountData() {
        Address address1 = new Address("Ulica", "13");
        Address address2 = new Address("Ulica", "13");
        Account account = new Account(address1);
        Account account2 = new Account(address2);
        Account account3 = new Account();
        return Arrays.asList(account, account2, account3);
    }
}
