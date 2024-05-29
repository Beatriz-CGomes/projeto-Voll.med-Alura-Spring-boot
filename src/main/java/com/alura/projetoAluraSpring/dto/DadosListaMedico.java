package com.alura.projetoAluraSpring.dto;

import com.alura.projetoAluraSpring.enums.Especialidade;
import com.alura.projetoAluraSpring.model.Medico;

public record DadosListaMedico(String nome, String email, String crm, Especialidade especialidade) {

    public DadosListaMedico(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
