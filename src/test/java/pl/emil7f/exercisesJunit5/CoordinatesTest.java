package pl.emil7f.exercisesJunit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    private Coordinates coordinates;

    @BeforeEach
    void setup() {
        coordinates = new Coordinates(1, 1);
    }

    @Test
    void copyWithAnotherParamsShouldReturnCorrectPosition() {
        // given
        // when
        Coordinates result = Coordinates.copy(coordinates, 3, 3);
        //then
        assertThat(result.getX(), is(4));
        assertThat(result.getY(), is(4));
    }

    @Test
    void copyAndOriginalCoordinatesShouldBeEqual() {
        // given
        // when
        Coordinates copyCoordinates = Coordinates.copy(coordinates, 0, 0);
        //then
        assertThat(copyCoordinates, equalTo(coordinates));
        assertThat(copyCoordinates, not(sameInstance(coordinates)));
    }

    @Test
    void wrongValueInConstructorShouldThrowIllegalArgumentException() {
        // given
        int wrongX = -1;
        int wrongY = 101;
        // when
        Coordinates coordinates;
        //then
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(wrongX, 5));
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(5, wrongY));
    }


}
