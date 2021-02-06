package pl.emil7f.cart;

import pl.emil7f.Meal;
import pl.emil7f.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Order> orders = new ArrayList<>();

    void addOrderToCart(Order order) {
        this.orders.add(order);
    }

    void clearCart() {
        this.orders.clear();
    }

    void simulateLargeOrder() {
        for (int i = 0; i < 1000; i++) {
            Meal meal = new Meal(i % 10, "hamburger nr: " + i);
            Order order = new Order();
            order.addMealToOrder(meal);
            addOrderToCart(order);
        }
        System.out.println("Cart size"+ orders.size());
        clearCart();
    }

    public List<Order> getOrders() {
        return orders;
    }
}
