package com.alura.projetoAluraSpring.dominio.medico;

import com.alura.projetoAluraSpring.dominio.enums.Especialidade;

public record DadosListaMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public DadosListaMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
