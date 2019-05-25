package br.com.orion.exercicio.entity;

import java.math.BigDecimal;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Desconto
 * @author Arilson Santos
 * @since 19/05/2019
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Desconto {

    private Long id;
    private Long idFuncionario;
    private BigDecimal valorDesconto;

	public String toString() {
        return "[" + "ID DESCONTO = " + getId() + ", ID FUNCIONARIO = " + getIdFuncionario() + ", VALOR DESCONTO = " + getValorDesconto() + "]";
    }
    


}