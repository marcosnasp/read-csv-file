package org.example.filter;

import org.example.java.domain.Person;

import java.util.List;
import java.util.Optional;

/**
 * Exercitando o uso da API Streams em Java
 */
public class PersonFilters {

    private final List<Person> persons;

    public PersonFilters(List<Person> persons) {
        this.persons = persons;
    }

    public Optional<Person> findById(Long id) {
        List<Person> persons = this.persons.stream().filter(p -> id.equals(p.getId())).toList();
        if (!persons.isEmpty()) {
            return Optional.of(persons.get(0));
        } else {
            return Optional.empty();
        }
    }

}
