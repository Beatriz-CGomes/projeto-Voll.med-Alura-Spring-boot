package com.alura.projetoAluraSpring.dominio.medico;

import com.alura.projetoAluraSpring.dominio.endereco.DadosEndereco;
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
