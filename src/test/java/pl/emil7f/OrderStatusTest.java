package pl.emil7f;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

class OrderStatusTest {

    @ParameterizedTest
    @DisplayName("Test where source of parameters is enum class")
    @EnumSource(OrderStatus.class)
    void allOrderStatusShouldBeOrderThan15Characters(OrderStatus orderStatus) {
        assertThat(orderStatus.toString().length(), lessThan(15));
    }

}
