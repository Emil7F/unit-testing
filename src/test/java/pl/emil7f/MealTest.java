package pl.emil7f;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class MealTest {


    @Test
    void shouldReturnDiscountedPrice() {
        // given
        Meal meal = new Meal(35);
        // when
        int discountedPrice = meal.getDiscountedPrice(7);
        //then
        Assertions.assertEquals(28, discountedPrice);
        assertThat(discountedPrice).isEqualTo(28);      // AssertJ

    }

    @Test
    void referencesToTheSameObjectShouldBeEqual() {
        // given
        //when
        Meal meal1 = new Meal(10);
        Meal meal2 = meal1;
        //then
        Assertions.assertSame(meal1, meal2);
        assertThat(meal1).isSameAs(meal2);         // AssertJ

    }

    @Test
    void referencesToDifferentObjectShouldNotBeEqual() {
        // given
        //when
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(10);
        //then
        Assertions.assertNotSame(meal1, meal2);
        assertThat(meal1).isNotSameAs(meal2);       //AssertJ
    }

    @Test
    void twoMealsShouldBeEqualWhenPriceAreTheSame() {
    // given when
        Meal meal1 = new Meal(10, "Burger");
        Meal meal2 = new Meal(10, "Burger");

        //then
        Assertions.assertEquals(meal1,meal2);
        assertThat(meal1).isEqualTo(meal2);

    }


}
