package com.alura.projetoAluraSpring.controller;

import com.alura.projetoAluraSpring.model.medicoCadastro;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {


    @PostMapping
    public void cadastrar(@RequestBody medicoCadastro medico){
        System.out.println(medico);
    }

}
