package com.alura.projetoAluraSpring.controller;

import com.alura.projetoAluraSpring.dominio.medico.*;
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
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@Valid @RequestBody MedicoCadastro dados, UriComponentsBuilder uriB) {
        var medico = new Medico(dados);
        medicoRepository.save(medico);

        var uri = uriB.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body((new DadosDetalhementoMedico(medico)));

    }

    @GetMapping
    public ResponseEntity<Page<DadosListaMedico>> listMedico(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable pagina) {
        var page = medicoRepository.findAllByAtivoTrue(pagina).map(DadosListaMedico::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@org.jetbrains.annotations.NotNull @Valid @RequestBody DadosAtualizacaoMedico dados) {
        //carregando por id
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhementoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        // medicoRepository.deleteById(id);
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscandoPoriD(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhementoMedico((medico)));
    }
}

