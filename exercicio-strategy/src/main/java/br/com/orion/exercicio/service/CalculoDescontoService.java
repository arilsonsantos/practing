package br.com.orion.exercicio.service;

import java.util.List;

import br.com.orion.exercicio.entity.dto.FuncionarioSalarioLiquidoDto;

/**
 * CalculoDescontoService
 * 
 * @author Arilson Santos
 * @since 19/05/2019
 * @version 1.0
 */
public class CalculoDescontoService implements ICalculoDesconto {

    public List<FuncionarioSalarioLiquidoDto> executar(AbstractCalculoDesconto calculoDesconto) {
        return calculoDesconto.executar();
    }

}