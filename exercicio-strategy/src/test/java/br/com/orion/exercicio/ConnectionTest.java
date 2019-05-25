package br.com.orion.exercicio;


import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.sql.Connection;

import org.junit.Test;

import br.com.orion.exercicio.jdbc.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Arilson Santos
 * @author Arilson Santos
 * @since 19/05/2019
 */
@Slf4j
public class ConnectionTest {

    @Test
    public void testConnectionDataBase() {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        Connection connection = connectionFactory.getConnection();

        log.info("Testando conexão com o banco de dados");
        assertThat(connection, isA(Connection.class));
        assertThat(connection, notNullValue());
    }
    
}