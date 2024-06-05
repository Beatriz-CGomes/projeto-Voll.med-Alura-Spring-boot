package com.alura.projetoAluraSpring.dominio.medico;

import com.alura.projetoAluraSpring.dominio.endereco.Endereco;
import com.alura.projetoAluraSpring.dominio.enums.Especialidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Medicos")
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;


    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(MedicoCadastro cadastroMedico) {
        this.ativo = true;
        this.nome = cadastroMedico.nome();
        this.email = cadastroMedico.email();
        this.telefone = cadastroMedico.telefone();
        this.crm = cadastroMedico.crm();
        this.endereco = new Endereco(cadastroMedico.endereco());
        this.especialidade = cadastroMedico.especialidade();
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico medico) {
        if (medico.nome() != null) {
            this.nome = medico.nome();
        }
        if (medico.telefone() != null) {
            this.telefone = medico.telefone();
        }
        if (medico.endereco() != null) {
            this.endereco.atualizarInformacoes(medico.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
