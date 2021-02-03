package pl.emil7f;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class AccountTest {

    @Test
    void newlyCreatedAccountShouldNotBeActive() {
        // given
        // when
        Account newAccount = new Account();
        //then
        assertFalse(newAccount.isActive());
        assertThat(newAccount.isActive(), equalTo(false));
        assertThat(newAccount.isActive(), is(false));

    }

    @Test
    void activatedAccountShouldHaveActiveFlagSet() {
        // given
        Account account = new Account();
        // when
        account.activate();
        //then
        assertTrue(account.isActive());

        assertThat(account.isActive(), equalTo(true));
        assertThat(account.isActive(), is(true));

    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet() {
        // given
        Account account = new Account();
        // when
        account.activate();
        Address address = account.getDefaultDeliveryAddress();
        //then
        assertEquals(null, address);
        assertNull(address);

        assertThat(address, nullValue());

    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet() {
        // given
        Address address = new Address("Krakowska", "7");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);
        // when
        Address deliveryAddress = account.getDefaultDeliveryAddress();
        //then
        assertNotNull(deliveryAddress);
        assertThat(deliveryAddress, notNullValue());
    }

    @Test
    @DisplayName("assumingThat() example")
    void newAccountWithNotNullAddressShouldBeActive() {
        // given
        Address address = new Address("Street", "15");
        // when
        Account account = new Account(address);

        //then
        /**
         * assumingThat(boolean, Executable ()-> )
         * Execute function only if the supplied assumption is valid
         */
        assumingThat(address != null, () -> {
            assertTrue(account.isActive());
        });
    }

    @RepeatedTest(5)
    @DisplayName("5 times repeated for newly created account is not active")
    void newlyCreatedAccountShouldNotBeActivatedRepeatedFiveTimes() {
        // given
        // when
        Account account = new Account();

        //then
        assertFalse((account.isActive()));

    }

    @Test
    void invalidEmailShouldThrowException() {
        // given
        Account account = new Account();
        // when
        //then
        assertThrows(IllegalArgumentException.class, () -> account.setEmail("wrongEmail"));
    }

    @Test
    void validEmailShouldBeSet() {
        // given
        Account account = new Account();
        // when
        account.setEmail("emilfigzal@gmail.com");
        //then
        assertThat(account.getEmail(), is("emilfigzal@gmail.com"));
    }

}
