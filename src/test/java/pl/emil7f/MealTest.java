package pl.emil7f;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MealTest {


    @Test
    void shouldReturnDiscountedPrice() {
        // given
        Meal meal = new Meal(35);
        // when
        int discountedPrice = meal.getDiscountedPrice(7);
        //then
        Assertions.assertEquals(28, discountedPrice);
        assertThat(discountedPrice, equalTo(28));
    }

    @Test
    void referencesToTheSameObjectShouldBeEqual() {
        // given
        //when
        Meal meal1 = new Meal(10);
        Meal meal2 = meal1;
        //then
        Assertions.assertSame(meal1, meal2);
        assertThat(meal1, sameInstance(meal2));
    }

    @Test
    void referencesToDifferentObjectShouldNotBeEqual() {
        // given
        //when
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(10);
        //then
        Assertions.assertNotSame(meal1, meal2);
        assertThat(meal1, not(sameInstance(meal2)));
    }

    @Test
    void twoMealsShouldBeEqualWhenPriceAreTheSame() {
        // given
        Meal meal1 = new Meal(10, "Burger");
        Meal meal2 = new Meal(10, "Burger");
        // when
        //then
        Assertions.assertEquals(meal1, meal2);
        assertThat(meal1, equalTo(meal2));
    }

    @Test
    void exceptionShouldBeThrownIfDiscountIsHigherThanThePrice() {
        // given
        Meal meal = new Meal(8, "Soup");
        // when
        //then
        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountedPrice(10));
    }

    @ParameterizedTest
    @DisplayName("Test where source of parameters is array given in @valueSource annotation")
    @ValueSource(ints = {5, 10, 15, 19})
    void mealPricesShouldBeLowerThan20(int price) {
        assertThat(price, lessThan(20));
    }

    @ParameterizedTest
    @DisplayName("First test where source is static method")
    @MethodSource("createMealsWithNameAndPrice")
    void burgersShouldHaveCorrectNameAndPrice(String name, int price) {
        assertThat(name, containsString("burger"));
        assertThat(price, greaterThanOrEqualTo(9));

    }

    private static Stream<Arguments> createMealsWithNameAndPrice() {
        return Stream.of(
                Arguments.of("Hamburger", 10),
                Arguments.of("Cheeseburger", 10)
        );
    }

    @ParameterizedTest
    @DisplayName("Second test where source is static method")
    @MethodSource("createCakeNames")
    void cakesShouldHaveCorrectNames(String name) {
        assertAll(
                () -> assertThat(name, containsString("Cake")),
                () -> assertThat(name, notNullValue())
        );


    }

    private static Stream<String> createCakeNames() {
        List<String> cakeNames = Arrays.asList("CheeseCake", "FruitCake", "CupCake");
        return cakeNames.stream();
    }

    /**
     * @ExtendWith annotation allow us to ignore exceptions.
     * implement TestExecutionExceptionHandler to your class and override handleTestExecutionException()
     *
     */
    @ExtendWith(IAExceptionIgnoreExtension.class)
    @ParameterizedTest
    @DisplayName("Test where source of parameters is array given in @valueSource annotation")
    @ValueSource(ints = {3, 5, 1, 8})
    void mealPricesShouldBeLowerThan10(int price) {
        if (price > 5) {
            throw new IllegalArgumentException();
        }
        assertThat(price, lessThan(10));
    }


}
