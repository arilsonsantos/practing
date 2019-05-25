package br.com.orion.exercicio.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Para facilitar o desenvolvimento, essa classe est� configurada com a url e os
 * dados de acesso do MySQL local que cont�m as tabelas e os dados a serem
 * utilizados durante o desenvolvimento dessa avalia��o.
 * 
 * @author Will Nascimento
 * @version 1.0
 * @since 23/06/2018
 *
 */
public class ConnectionFactory {
	private Connection connection;

	public Connection getConnection() {

		try {
			if (connection == null) {
				connection = DriverManager
						.getConnection("jdbc:postgresql://localhost:15432/exercicio?user=postgres&password=123");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return connection;
	}

	public void close() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
