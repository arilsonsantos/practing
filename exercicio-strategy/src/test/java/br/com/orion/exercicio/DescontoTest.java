package br.com.orion.exercicio;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import br.com.orion.exercicio.dao.DescontoDao;
import br.com.orion.exercicio.entity.Desconto;
import br.com.orion.exercicio.jdbc.ConnectionFactory;

/**
 * FuncionarioDaoTest
 * @author Arilson Santos
 * @since 19/05/2019
 */
public class DescontoTest {

    @Test
    public void testFindAll() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        DescontoDao descontoDao = new DescontoDao(connectionFactory);
        List<Desconto> descontos = descontoDao.findAll();

        assertThat(descontos, notNullValue());
    }
}