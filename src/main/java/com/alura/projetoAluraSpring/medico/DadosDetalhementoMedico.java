package com.alura.projetoAluraSpring.medico;

import com.alura.projetoAluraSpring.endereco.Endereco;
import com.alura.projetoAluraSpring.enums.Especialidade;

public record DadosDetalhementoMedico(Long id, String nome, String email, String crm, String telefone,
 Especialidade especialidade, Endereco endereco) {

    public DadosDetalhementoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(),
                medico.getEspecialidade(), medico.getEndereco());
    }

}
