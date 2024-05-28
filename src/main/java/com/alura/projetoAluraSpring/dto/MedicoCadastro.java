package com.alura.projetoAluraSpring.dto;

import com.alura.projetoAluraSpring.enums.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


public record MedicoCadastro(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,


        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid
        DadosEndereco endereco) {

}
