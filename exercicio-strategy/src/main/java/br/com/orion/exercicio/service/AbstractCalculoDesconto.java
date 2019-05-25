package br.com.orion.exercicio.service;

import java.util.List;

import br.com.orion.exercicio.entity.dto.FuncionarioSalarioLiquidoDto;

/**
 * AbstractCalculoDesconto
 * 
 * @author Arilson Santos
 * @since 19/05/2019
 * @version 1.0
 */
public abstract class AbstractCalculoDesconto {

    protected abstract List<FuncionarioSalarioLiquidoDto>  executar();
    
}