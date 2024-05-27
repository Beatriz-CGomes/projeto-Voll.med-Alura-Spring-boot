package com.alura.projetoAluraSpring.model;

import com.alura.projetoAluraSpring.model.enums.Especialidade;

public record medicoCadastro(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {


}
