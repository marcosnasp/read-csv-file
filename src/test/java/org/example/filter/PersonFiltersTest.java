package org.example.filter;

import org.example.java.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PersonFiltersTest {

    private static PersonFilters personFilters;
    private static List<Person> persons;

    @BeforeAll
    public static void setUp() {
        persons = List.of(new Person(1L, "Marcos", "Avenida Desembargador Moreira, 2222", "Fortaleza"),
                new Person(2L, "Nonato", "Avenida dos Expedicionários, 233", "Fortaleza"));
        personFilters = new PersonFilters(persons);
    }

    @DisplayName("Dado um Id de uma Pessoa Encontre-a")
    @Test
    public void GivenOneIdFindAPersonTest() {
        Assertions.assertEquals(persons.get(0), personFilters.findById(1L).get());
    }


}
