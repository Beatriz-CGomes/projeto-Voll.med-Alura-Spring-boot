package com.alura.projetoAluraSpring.repository;

import com.alura.projetoAluraSpring.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
