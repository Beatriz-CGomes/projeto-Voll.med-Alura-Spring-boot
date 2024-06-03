package com.alura.projetoAluraSpring.paciente;

import com.alura.projetoAluraSpring.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(

        @NotNull
        Long id,

        String nome,

        String telefone,

        DadosEndereco endereco
) {
}


