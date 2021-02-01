package pl.emil7f;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class AddressTest {

    @ParameterizedTest
    @CsvSource({"Fabryczna, 10",
            "Armii Krajowej, 11",
            "Gliwicka, 130",
            "Tytusa ',' Romka i Atomka, 30"})
    void givenAddressesShouldNotBeEmptyAndHaveProperNames(String street, String number){
        assertThat(street,  notNullValue());
        assertThat(street,  containsString("a"));
        assertThat(number, notNullValue());
        assertThat(number.length(), greaterThanOrEqualTo(1));
    }

    /**
    Parametrized test, where source of data is a csv file
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/addresses.csv")
    void addressesFromFileShouldNotBeEmptyAndHaveProperNames(String street, String number){
        assertThat(street,  notNullValue());
        assertThat(street,  containsString("a"));
        assertThat(number, notNullValue());
        assertThat(number.length(), greaterThanOrEqualTo(1));
    }

}
