package pl.emil7f;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void newlyCreatedAccountShouldNotBeActive() {
        // given
        // when
        Account newAccount = new Account();
        //then
        assertFalse(newAccount.isActive());
        assertThat(newAccount.isActive()).isFalse();   // AssertJ
    }

    @Test
    void activatedAccountShouldHaveActiveFlagSet() {
        // given
        Account account = new Account();
        // when
        account.activate();
        //then
        assertTrue(account.isActive());
        assertThat(account.isActive()).isTrue();    // AssertJ


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
        assertThat(address).isNull();       // AssertJ

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
        assertThat(address).isNotNull();        // AssertJ

    }

}
