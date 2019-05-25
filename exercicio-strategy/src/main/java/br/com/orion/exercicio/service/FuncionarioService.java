package br.com.orion.exercicio.service;

import java.util.List;

import br.com.orion.exercicio.dao.FuncionarioDao;
import br.com.orion.exercicio.entity.Funcionario;
import br.com.orion.exercicio.jdbc.ConnectionFactory;

/**
 * FuncionarioService
 */
public class FuncionarioService {

    public List<Funcionario> findAll() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        FuncionarioDao funcionarioDao = new FuncionarioDao(connectionFactory);

        return funcionarioDao.findAll();
    }
}