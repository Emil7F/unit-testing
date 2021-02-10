package pl.emil7f.exercisesJunit5;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    private static Coordinates coordinates;
    private static Unit unit;
    private static Cargo cargo;

    @BeforeEach
    void setup() {
        coordinates = new Coordinates(0, 0);
        unit = new Unit(coordinates, 50, 50);

    }

    @Test
    void shouldReturnCorrectCoordinatesAfterMove() {
        // given
        // when
        Coordinates coordinatesAfterMove = unit.move(5, 5);
        //then
        assertThat(coordinatesAfterMove.getX(), Matchers.is(5));
        assertThat(coordinatesAfterMove.getY(), Matchers.is(5));

    }

    @Test
    void shouldThrowIllegalStateExceptionWhenItIsToFar() {
        // given
        // when

        //then
        assertThrows(IllegalStateException.class, () -> unit.move(26, 25));
    }

    @Test
    void shouldLoseFuelWhenMoving() {
        // given
        // when
        unit.move(0, 5);
        //then
        assertThat(unit.getFuel(), Matchers.equalTo(45));
    }

    //TODO:  unloadingAllCargoShouldReduceUnitLoadToZero

    @Test
    void fuelingShouldNotExceedMaxFuelLimit() {
        // given
        // when
        unit.move(0, 5);

        //then
        assertThat(unit.getLoad(), Matchers.lessThanOrEqualTo(50));
    }

    @Test
    void cargoCanNotExceedMaxWeightLimit() {
        // given
        // when
        cargo = new Cargo("cargo", 51);
        //then
        assertThrows(IllegalStateException.class, () -> unit.loadCargo(cargo));
    }

    @Test
    void unloadingAllCargoShouldReduceUnitLoadToZero(){
        // given
        cargo = new Cargo("cargo", 10);
        Cargo cargo1 = new Cargo("cargo1", 10);
        Cargo cargo2 = new Cargo("cargo2", 10);
        unit.loadCargo(cargo);
        unit.loadCargo(cargo1);
        unit.loadCargo(cargo2);
        // when
        unit.unloadAllCargo();
        //then
        assertThat(unit.getLoad(), Matchers.equalTo(0));
    }


}
