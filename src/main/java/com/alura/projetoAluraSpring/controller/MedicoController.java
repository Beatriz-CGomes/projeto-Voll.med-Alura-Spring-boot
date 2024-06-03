package com.alura.projetoAluraSpring.controller;

import com.alura.projetoAluraSpring.medico.DadosAtualizacaoMedico;
import com.alura.projetoAluraSpring.medico.DadosListaMedico;
import com.alura.projetoAluraSpring.medico.MedicoCadastro;
import com.alura.projetoAluraSpring.medico.Medico;
import com.alura.projetoAluraSpring.medico.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@Valid @RequestBody MedicoCadastro medico) {
        medicoRepository.save(new Medico(medico));

    }

    @GetMapping
    public Page<DadosListaMedico> listMedico(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable pagina) {
        return medicoRepository.findAllByAtivoTrue(pagina).map(DadosListaMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@Valid @RequestBody DadosAtualizacaoMedico dados) {
        //carregando por id
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
       // medicoRepository.deleteById(id);
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
    }
}

