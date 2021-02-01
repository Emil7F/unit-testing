package pl.emil7f;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;


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

    @TestFactory
    Collection<DynamicTest> dynamicTestCollection() {
        return Arrays.asList(
                dynamicTest("Dynamic test 1", () -> assertThat(5, lessThan(6))),
                dynamicTest("Dynamic test2", () -> assertThat("Laska".length(), greaterThanOrEqualTo(4)))

        );
    }
    /**
     * Dynamic test consist of name and an action, this action can be assertion
     *
     */
    @TestFactory
    Collection<DynamicTest> calculateMealPrices() {
        Order order = new Order();
        order.addMealToOrder(new Meal(10, 2, "Hamburger"));
        order.addMealToOrder(new Meal(7, 4, "Fries"));
        order.addMealToOrder(new Meal(22, 3, "Pizza"));

        Collection<DynamicTest> dynamicTests = new ArrayList<>();

        for (int i = 0; i < order.getMeals().size(); i++) {
            int price = order.getMeals().get(i).getPrice();
            int quantity = order.getMeals().get(i).getQuantity();

            Executable executable = () -> {
                assertThat(calculatePrice(price, quantity), lessThan(67));
            };
            String name = "Test name: " + i;
            DynamicTest dynamicTest = DynamicTest.dynamicTest(name, executable);
            dynamicTests.add(dynamicTest);

        }
        return dynamicTests;
    }


    private int calculatePrice(int price, int quantity) {
        return price * quantity;
    }

}
