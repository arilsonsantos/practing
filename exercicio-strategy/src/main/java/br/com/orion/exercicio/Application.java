package br.com.orion.exercicio;

import java.util.List;

import br.com.orion.exercicio.entity.dto.FuncionarioSalarioLiquidoDto;
import br.com.orion.exercicio.service.AbstractCalculoDesconto;
import br.com.orion.exercicio.service.FuncionarioOrderBySalarioLiquidoDescService;
import br.com.orion.exercicio.service.CalculoDescontoService;
import br.com.orion.exercicio.service.ICalculoDesconto;

/**
 * Application
 * 
 * @author Arilson Santos
 * @since 19/05/2019
 * @version 1.0
 */
public class Application {

    public static void main(String[] args) {
        ICalculoDesconto calculoDesconto = new CalculoDescontoService();
        AbstractCalculoDesconto orderBySalarioLiquidoDesc = new FuncionarioOrderBySalarioLiquidoDescService();
        List<FuncionarioSalarioLiquidoDto> lista = calculoDesconto.executar(orderBySalarioLiquidoDesc);

        lista.forEach(f -> System.out.println(f));
    }

    public static void imprimir(List<FuncionarioSalarioLiquidoDto> lista) {
        lista.stream()
            .sorted((n1, n2) -> n1.getNome().compareTo(n2.getNome()))
            .sorted((s1, s2) -> s2.getSalarioLiquido().compareTo(s1.getSalarioLiquido()))
            .forEach(f -> System.out.println(f));
    }
}