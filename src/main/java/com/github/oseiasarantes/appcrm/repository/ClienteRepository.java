package com.github.oseiasarantes.appcrm.repository;

import com.github.oseiasarantes.appcrm.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
    boolean existsByCpf(String cpf);
}
