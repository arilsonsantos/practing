package br.com.orion.exercicio.entity.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * FuncionarioDescontoDto
 * @author Arilson Santos
 * @since 19/05/2019
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class FuncionarioSalarioLiquidoDto {

    private Long id;
    private String nome;
    private BigDecimal salarioBruto;
    private BigDecimal totalDesconto;
    private BigDecimal salarioLiquido;

    public String toString() {
        return "[" + "ID DO FUNCIONARIO = " + getId() + ",NOME DO CLIENTE = " + getNome()
                + ", SALÁRIO BRUTO = " + getSalarioBruto() 
                + ", TOTAL DESCONTO = " + getTotalDesconto() 
                + ", SALÁRIO LÍQUIDO = " + getSalarioLiquido() + "]";
    }

}