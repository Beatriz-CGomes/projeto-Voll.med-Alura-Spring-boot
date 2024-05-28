package com.alura.projetoAluraSpring.model;

import com.alura.projetoAluraSpring.dto.DadosEndereco;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;


    public Endereco(DadosEndereco enderecoDados){
        this.logradouro = enderecoDados.logradouro();
        this.bairro = enderecoDados.bairro();
        this.cep = enderecoDados.cep();
        this.numero = enderecoDados.numero();
        this.complemento = enderecoDados.complemento();
        this.cidade = enderecoDados.cidade();
        this.uf = enderecoDados.uf();
    }
}
