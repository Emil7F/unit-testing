package pl.emil7f;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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
        Assertions.assertEquals(meal1,meal2);
        assertThat(meal1, equalTo(meal2));
    }

    @Test
    void exceptionShouldBeThrownIfDiscountIsHigherThanThePrice(){
        // given
        Meal meal = new Meal(8, "Soup");
        // when
        //then
        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountedPrice(10));
    }


}
