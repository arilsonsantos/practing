package br.com.orion.exercicio.entity;

import java.math.BigDecimal;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Funcionario
 * @author Arilson Santos
 * @since 19/05/2019
 * @version 1.0
 */
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Funcionario {

    private Long id;
    private String nome;
    private BigDecimal valorSalarioBruto;

    public Funcionario(Long id) {
        this.id = id;
    }

    public String toString() {
        return "[" + "ID DO FUNCIONARIO = " + getId() + ",NOME = " + getNome() + "'"
                + ",VALOR SALÁRIO BRUTO = " + getValorSalarioBruto() + "]";
    }

}