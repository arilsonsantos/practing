package br.com.orion.exercicio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.orion.exercicio.entity.Desconto;
import br.com.orion.exercicio.jdbc.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * Pensando ainda numa abordagem diferente do que poderia ser mais didático e,
 * novamente, usando uma abordagem mais Java 8, optei pela solução abaixo. Como
 * não há paginação e todos os descontos deverão ser retornados, sem qualquer
 * filtro, achei melhor, neste caso, trazer todos de uma só vez a fim de evitar
 * muitas requisições ao banco e efetuar o cáculo do desconto já com a lista de
 * descontos em "mãos" Em FuncionarioDao explico uma outra possibilidade de
 * realizar essas requisições.
 * 
 * @author Arilson Santos
 * @since 19/05/2019
 * @version 1.0
 */
@Slf4j
public class DescontoDao extends AbstractDao<Desconto> {

    private static final String FUNCIONARIOS = "SELECT ID, ID_FUNCIONARIO, VL_DESCONTO FROM DESCONTO";

    public DescontoDao(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    @Override
    public List<Desconto> findAll() {
        List<Desconto> descontos = new ArrayList<>();

        try (Connection connection = connectionFactory.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(FUNCIONARIOS);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Desconto desconto = new Desconto();
                desconto.setId(rs.getLong("ID"));
                desconto.setIdFuncionario(rs.getLong("ID_FUNCIONARIO"));
                desconto.setValorDesconto(rs.getBigDecimal("VL_DESCONTO"));
                descontos.add(desconto);
            }

        } catch (SQLException e) {
            log.error("Ocorreu um erro ao acessar o banco de dados: ", e.getCause());
        }

        return descontos;
    }

}