package pl.emil7f;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

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
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet(){
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

}
