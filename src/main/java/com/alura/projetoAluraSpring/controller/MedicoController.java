package com.alura.projetoAluraSpring.controller;

import com.alura.projetoAluraSpring.dto.MedicoCadastro;
import com.alura.projetoAluraSpring.model.Medico;
import com.alura.projetoAluraSpring.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@Valid @RequestBody MedicoCadastro medico){
        medicoRepository.save(new Medico(medico));
    }

}

