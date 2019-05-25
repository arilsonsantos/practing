package br.com.orion.exercicio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.orion.exercicio.entity.Funcionario;
import br.com.orion.exercicio.jdbc.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * As consultas às tabelas Funcionario e Descontos poderiam ser em uma única
 * query (Join), retornando os resultados para uma lista de FuncionarioDescontoDto,
 * mas o exercício seria bastante simplificado e talvez fugisse do propósito,
 * visto que não se faria necessário a inclusão das classes Funcionario e Desconto, 
 * de qualquer forma, seria uma solução a descutir. Sendo assim, o DAO abaixo
 * retorna uma lista pura de todos os funcionários, sem nenhum critério.
 * 
 * @author Arilson Santos
 * @since 19/05/2019
 * @version 1.0
 */
@Slf4j
public class FuncionarioDao extends AbstractDao<Funcionario> {

    private static final String FUNCIONARIOS = "SELECT ID, NOME, VL_SALARIO_BRUTO FROM FUNCIONARIO";

    public FuncionarioDao(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    @Override
    public List<Funcionario> findAll() {
        List<Funcionario> funcionarios = new ArrayList<>();

        try (Connection connection = connectionFactory.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(FUNCIONARIOS);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getLong("ID"));
                funcionario.setNome(rs.getString("NOME"));
                funcionario.setValorSalarioBruto(rs.getBigDecimal("VL_SALARIO_BRUTO"));
                funcionarios.add(funcionario);
            }

        } catch (SQLException e) {
            log.error("Ocorreu um erro ao acessar o banco de dados: ", e.getCause());
        }

        return funcionarios;
    }

}