package pl.emil7f;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test cases for Cart")
class CartTest {

    @Disabled  // test is ignored
    @Test
    void simulateLargeOrder(){
        // given
        Cart cart = new Cart();
        // when
        //then
        assertTimeout(Duration.ofMillis(100), () -> cart.simulateLargeOrder());
        // Metoda do testowania czasu wykonania metody
        // Metoda simulateLargeOrder wykona się w czasie mniejszym niz 10ms
    }

}
