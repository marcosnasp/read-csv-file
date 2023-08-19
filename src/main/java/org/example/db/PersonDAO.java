package org.example.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.example.java.domain.Person;

public class PersonDAO {

    public static final Logger LOGGER = Logger.getLogger(PersonDAO.class.getName());

    public void save(Person person) {
        String sql = """
                INSERT INTO persons (name, address, city)
                VALUES (?, ?, ?)
                """;
            
        try {
            Connection connection = ConnectionManager.getConnection();   
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setString(1, person.getName());
                preparedStatement.setString(2, person.getAddress());
                preparedStatement.setString(3, person.getCity());

                int affectedLines = preparedStatement.executeUpdate();
                if (affectedLines > 0) {
                    LOGGER.info(String.format("Dados da Pessoa: %s foram inseridos com sucesso.", person.toString()));
                }
            } catch (SQLException e) {
                LOGGER.info(String.format("Falha na realização da consulta, ver detalhes: %s", e.getMessage()));
            }
        } catch (SQLException e) {
            LOGGER.info(String.format("Falha na abertura de conexão, ver detalhes: %s", e.getMessage()));
        }
    }

    public Person findPersonById(Long id) {
        Person person = new Person();

        String sql = """
                SELECT p.id, p.name, p.address, p.city
                FROM persons p WHERE p.id = ?
                """;

        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    person.setId(resultSet.getLong("id"));
                    person.setAddress(resultSet.getString("address"));
                    person.setCity(resultSet.getString("city"));
                    person.setName(resultSet.getString("name"));
                }
            } catch (SQLException e) {
                LOGGER.info(String.format("Falha na realização da consulta, ver detalhes: %s", e.getMessage()));
            }
        } catch (SQLException e) {
            LOGGER.info(String.format("Falha na realização da consulta, ver detalhes: %s", e.getMessage()));
        }
        return person;
    }

}