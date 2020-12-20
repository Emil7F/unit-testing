package pl.emil7f;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Meal> meals = new ArrayList<>();

    public List<Meal> getMeals() {
        return meals;
    }

    public void addMealToOrder(Meal meal) {
        meals.add(meal);
    }

    public void removeMealFromOrder(Meal meal){
        meals.remove(meal);
    }

    void cancel(){
        this.meals.clear();
    }
}
