package br.com.orion.exercicio;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import br.com.orion.exercicio.dao.FuncionarioDao;
import br.com.orion.exercicio.entity.Funcionario;
import br.com.orion.exercicio.jdbc.ConnectionFactory;

/**
 * FuncionarioDaoTest
 * @author Arilson Santos
 * @since 19/05/2019
 */
public class FuncionarioDaoTest {

    @Test
    public void testFindAll() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        FuncionarioDao funcionarioDao = new FuncionarioDao(connectionFactory);
        List<Funcionario> funcionarios = funcionarioDao.findAll();

        assertThat(funcionarios, notNullValue());
    }
}