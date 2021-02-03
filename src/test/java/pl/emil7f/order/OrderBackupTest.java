package pl.emil7f.order;

import org.junit.jupiter.api.*;
import pl.emil7f.Meal;
import pl.emil7f.order.Order;
import pl.emil7f.order.OrderBackup;

import java.io.IOException;


class OrderBackupTest {

    private static OrderBackup orderBackup;

    /**
     * BeforeAll & AfterAll muszą być statyczne, kompilator tego nie podkreśla.
     * Co za tym idzie obiekty do których się odnośni też muszą być statyczne.
     */
    @BeforeAll
    static void setup() throws IOException {
        orderBackup = new OrderBackup();
        orderBackup.createFile();   // file created in the target folder
    }

    @BeforeEach
    void appendTheStartOfTheLine() throws IOException {
        orderBackup.getWriter().append("New order: ");
    }

    @AfterEach
    void appendTheEndOfTheLine() throws IOException {
        orderBackup.getWriter().append(" backed up.");
    }


    @Test
    void backOrderWithOneMeal() throws IOException {
        // given
        Meal meal = new Meal(15, "Icecream");
        pl.emil7f.order.Order order = new Order();
        order.addMealToOrder(meal);
        // when
        orderBackup.backupOrder(order);
        //then
        System.out.println("Order: " + order.toString() + "backed up.");
    }

    @AfterAll
    static void tearDown() throws IOException {
        orderBackup.closeFile();

    }


}
