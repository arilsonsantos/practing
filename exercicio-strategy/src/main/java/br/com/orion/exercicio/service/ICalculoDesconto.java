package br.com.orion.exercicio.service;

import java.util.List;

import br.com.orion.exercicio.entity.dto.FuncionarioSalarioLiquidoDto;

/**
 * ICalculoDesconto
 * @author Arilson Santos
 * @since 19/05/2019
 * @version 1.0
 */
public interface ICalculoDesconto {

    List<FuncionarioSalarioLiquidoDto> executar(AbstractCalculoDesconto calculoDesconto);
}