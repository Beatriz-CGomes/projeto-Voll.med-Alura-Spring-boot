package com.alura.projetoAluraSpring.medico;

import com.alura.projetoAluraSpring.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(

        @NotNull
        Long id,
        String nome,
        String telefone,

        @Valid
        DadosEndereco endereco) {


}
