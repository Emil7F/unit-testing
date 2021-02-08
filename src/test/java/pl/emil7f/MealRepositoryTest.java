package pl.emil7f;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MealRepositoryTest {

    MealRepository mealRepository = new MealRepository();

    @BeforeEach
    void cleanUp(){
        mealRepository.getAllMeals().clear();
    }

    @Test
    void shouldBeAbleToAddMealToRepository() {
        // given
        Meal meal = new Meal(10, "Pizza");
        // when
        mealRepository.add(meal);
        //then
        assertThat(mealRepository.getAllMeals().get(0), is(meal));
    }

    @Test
    void shouldBeAbleToRemoveMealFromRepository(){
        // given
        Meal meal = new Meal(10, "Pizza");
        mealRepository.add(meal);
        // when
        mealRepository.delete(meal);
        //then
        assertThat(mealRepository.getAllMeals(), not(contains(meal)));
    }

    @Test
    void shouldBeAbleToFindMealByName(){

        // given
        Meal meal = new Meal(10, "Pizza");
        mealRepository.add(meal);
        // when
        List<Meal> results = mealRepository.findByName("Pizza");

        //then
        assertThat(results.size(), is(1));



    }
}
