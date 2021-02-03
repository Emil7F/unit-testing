package pl.emil7f.order;

import pl.emil7f.Meal;

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

    public void removeMealFromOrder(Meal meal) {
        meals.remove(meal);
    }

    void cancel() {
        this.meals.clear();
    }

    int totalPrice() {
        int sum = this.meals.stream().mapToInt(meal -> meal.getPrice()).sum();
        if (sum < 0) {
            throw new IllegalStateException("Price limit exceeded");
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Order{" +
                "meals=" + meals +
                '}';
    }
}
