package com.alura.projetoAluraSpring.controller;

import com.alura.projetoAluraSpring.dominio.paciente.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriB) {
        var paciente = new Paciente(dados);
        pacienteRepository.save(paciente);
        var uri = uriB.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable page) {
        var pagina = pacienteRepository.findAllByAtivoTrue(page).map(DadosListagemPaciente::new);
        return ResponseEntity.ok(pagina);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@Valid @RequestBody DadosAtualizacaoPaciente dados) {
        var paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity ResponseEntity(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity uscandoPoriD(@PathVariable Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }
}