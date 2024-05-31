package com.alura.projetoAluraSpring.dto;

import com.alura.projetoAluraSpring.enums.Especialidade;
import com.alura.projetoAluraSpring.model.Medico;

public record DadosListaMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public DadosListaMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
