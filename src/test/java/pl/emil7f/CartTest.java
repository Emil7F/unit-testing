package pl.emil7f;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

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
