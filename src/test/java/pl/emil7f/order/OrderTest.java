package pl.emil7f.order;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pl.emil7f.Meal;
import pl.emil7f.extensions.BeforeAfterExtension;
import pl.emil7f.order.Order;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(BeforeAfterExtension.class)
class OrderTest {

    private Order order;

    @BeforeEach
    void initializeOrder() {
        System.out.println("Before each");
        order = new Order();
    }

    @AfterEach
    void cleanUp() {
        System.out.println("After each");
        order.cancel();
    }

    @Test
    void testAssertArrayEquals() {
        // given
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        //then
        assertArrayEquals(array1, array2);

    }

    @Test
    void mealListShouldBeEmptyAfterCreationOrder() {
        // given
        // then
        assertThat(order.getMeals(), empty());
        assertThat(order.getMeals().size(), equalTo(0));
        assertThat(order.getMeals(), hasSize(0));
        MatcherAssert.assertThat(order.getMeals(), emptyCollectionOf(Meal.class));
    }

    @Test
    void addingMealToOrderShouldIncreaseOrderSize() {
        // given
        Meal meal = new Meal(2, "Pizza");
        int orderSize = order.getMeals().size();
        // when
        order.addMealToOrder(meal);
        //then
        assertThat(order.getMeals().size(), equalTo(orderSize + 1));
        assertThat(order.getMeals(), hasSize(1));
        assertThat(order.getMeals(), contains(meal));
        assertThat(order.getMeals(), hasItem(meal));
    }

    @Test
    void removingMealFromOrderShouldDecreaseOrderSize() {
        // given
        Meal meal = new Meal(3, "Burger");
        order.addMealToOrder(meal);
        // when
        int orderSize = order.getMeals().size();
        order.removeMealFromOrder(meal);
        //then
        assertThat(order.getMeals(), hasSize(0));
        assertThat(order.getMeals(), not(contains(meal)));
        assertThat(order.getMeals(), not(hasItem(meal)));
    }

    @Test
    void mealsShouldBeInCorrectOrderAfterAddingThemToOrder() {
        // given
        Meal meal1 = new Meal(15, "Pizza");
        Meal meal2 = new Meal(11, "Hot Dog");
        // when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);
        //then
        assertThat(order.getMeals(), hasSize(2));
        assertThat(order.getMeals().get(0), equalTo(meal1));
        assertThat(order.getMeals().get(1), equalTo(meal2));
        assertThat(order.getMeals(), contains(meal1, meal2));
        assertThat(order.getMeals(), containsInAnyOrder(meal2, meal1));

    }

    @Test
    void testIfTwoMealListsAreTheSame() {
        // given
        Meal meal1 = new Meal(15, "Pizza");
        Meal meal2 = new Meal(11, "Hot Dog");
        Meal meal3 = new Meal(17, "Kebab");
        // when
        List<Meal> meals1 = Arrays.asList(meal1, meal2);
        List<Meal> meals2 = Arrays.asList(meal1, meal2);
        //then
        assertThat(meals1, is(meals2));
    }

    @Test
    void orderTotalPriceShouldNotExceedsMaxIntValue() {
        // given
        Meal meal1 = new Meal(Integer.MAX_VALUE, "Pizza");
        Meal meal2 = new Meal(Integer.MAX_VALUE, "Hot Dog");
        // when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);
        //then
        assertThrows(IllegalStateException.class, () -> order.totalPrice());
    }

    @Test
    void emptyOrderTotalPriceShouldEqualZero() {
        // given  Order is created in BeforeEach
        // when

        //then
        assertThat(order.totalPrice(), is(0));
    }

    @Test
    void cancelingOrderShouldRemoveAllItemsFromMealsList() {
        // given
        Meal meal1 = new Meal(15, "Pizza");
        Meal meal2 = new Meal(18, "Hot Dog");
        // when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);
        order.cancel();
        //then
        assertThat(order.getMeals().size(), is(0));
    }

}
