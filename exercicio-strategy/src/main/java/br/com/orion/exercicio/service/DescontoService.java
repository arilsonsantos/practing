package br.com.orion.exercicio.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import br.com.orion.exercicio.dao.DescontoDao;
import br.com.orion.exercicio.entity.Desconto;
import br.com.orion.exercicio.jdbc.ConnectionFactory;

/**
 * DescontoService
 * Classe responsável por agrupar/somar os descontos por funcionário
 * Poderia fazer da forma tradicional, mas seria fazer o mais do mesmo, resolvi
 * desenvolver com uma abordagem Java 8
 * 
 * @author Arilson Santos
 * @since 19/05/2019
 * @version 1.0
 */
public class DescontoService {

    public List<Entry<Long, BigDecimal>> findAllSumDescontoGroupByFuncionario() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        DescontoDao descontoDao = new DescontoDao(connectionFactory);
        List<Desconto> descontos = descontoDao.findAll();

        List<Entry<Long, BigDecimal>> descontosAgrupados = descontos.stream()
                .collect(Collectors.groupingBy(Desconto::getIdFuncionario,
                        Collectors.reducing(BigDecimal.ZERO, Desconto::getValorDesconto, BigDecimal::add)))
                .entrySet().stream().collect(Collectors.toList());

        return descontosAgrupados;
    }
}