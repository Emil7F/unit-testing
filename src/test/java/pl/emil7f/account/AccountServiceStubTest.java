package pl.emil7f.account;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

class AccountServiceStubTest {

    @Test  // Stub example
    void getAllActiveAccounts(){
        // given
        AccountRepositoryStub accountRepositoryStub = new AccountRepositoryStub();
        AccountService accountService = new AccountService(accountRepositoryStub);
        // when
        List<Account> accountList = accountService.getAllActiveAccounts();
        //then
        assertThat(accountList, hasSize(2));
    }

}
