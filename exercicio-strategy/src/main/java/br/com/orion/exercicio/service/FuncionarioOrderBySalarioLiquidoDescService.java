package br.com.orion.exercicio.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Optional;

import br.com.orion.exercicio.entity.Funcionario;
import br.com.orion.exercicio.entity.dto.FuncionarioSalarioLiquidoDto;

/**
 * Mesmo sendo para apenas uma lista, adotei o padrão Stragy somente para deixar
 * aberto para novas extenções/tipos de descontos e/ou exibição de outras formas
 * da mesma lista
 * 
 * CalculoDescontoPorFuncionarioOrderBySalarioLiquidoDesc
 * 
 * @author Arilson Santos
 * @since 19/05/2019
 * @version 1.0
 */
public class FuncionarioOrderBySalarioLiquidoDescService extends AbstractCalculoDesconto {

    @Override
    public List<FuncionarioSalarioLiquidoDto> executar() {
        DescontoService descontoService = new DescontoService();
        FuncionarioService funcionarioService = new FuncionarioService();

        List<Funcionario> funcionarios = funcionarioService.findAll();
        List<Map.Entry<Long, BigDecimal>> descontosAgrupadosPorFuncionario = descontoService
                .findAllSumDescontoGroupByFuncionario();
        List<FuncionarioSalarioLiquidoDto> listDto = new ArrayList<>();

        funcionarios.forEach(funcionario -> {
            FuncionarioSalarioLiquidoDto dto = new FuncionarioSalarioLiquidoDto();
            dto.setId(funcionario.getId());
            dto.setNome(funcionario.getNome());
            dto.setSalarioBruto(funcionario.getValorSalarioBruto());
            dto.setTotalDesconto(getDescontoCalculadoPorFuncionario(descontosAgrupadosPorFuncionario, funcionario));
            dto.setSalarioLiquido(dto.getSalarioBruto().subtract(dto.getTotalDesconto()));
            listDto.add(dto);

        });

        return ordendarLista(listDto);

    }

    private BigDecimal getDescontoCalculadoPorFuncionario(List<Entry<Long, BigDecimal>> descontosAgrupadosPorFuncionario,
            Funcionario funcionario) {

        Optional<Map.Entry<Long, BigDecimal>> desconto = descontosAgrupadosPorFuncionario.stream()
                .filter(f -> f.getKey() == funcionario.getId()).findFirst();

        if (desconto.isPresent()) {
            return desconto.get().getValue();
        }

        return BigDecimal.ZERO;
    }

    private List<FuncionarioSalarioLiquidoDto> ordendarLista(List<FuncionarioSalarioLiquidoDto> lista) {
        return lista.stream().sorted((n1, n2) -> n1.getNome().compareTo(n2.getNome()))
                .sorted((s1, s2) -> s2.getSalarioLiquido().compareTo(s1.getSalarioLiquido()))
                .collect(Collectors.toList());
    }

}