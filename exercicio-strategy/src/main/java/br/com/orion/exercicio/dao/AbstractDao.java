package br.com.orion.exercicio.dao;

import java.sql.Connection;
import java.util.List;

import br.com.orion.exercicio.jdbc.ConnectionFactory;

/**
 * AbstractDao
 * @author Arilson Santos
 * @since 19/05/2019
 * @version 1.0
 */
public abstract class AbstractDao<T> {

    ConnectionFactory connectionFactory;

    AbstractDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    protected Connection getConnection() {
        return connectionFactory.getConnection();
    }

    protected void closeConnection() {
        connectionFactory.close();
    }

    protected abstract List<T> findAll();

    
}