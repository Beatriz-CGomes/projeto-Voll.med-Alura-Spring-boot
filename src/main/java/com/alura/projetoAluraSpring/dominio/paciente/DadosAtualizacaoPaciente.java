package com.alura.projetoAluraSpring.dominio.paciente;

import com.alura.projetoAluraSpring.dominio.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(

        @NotNull
        Long id,

        String nome,

        String telefone,

        DadosEndereco endereco
) {
}


