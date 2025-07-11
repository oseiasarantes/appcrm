package com.github.oseiasarantes.appcrm.service;

import com.github.oseiasarantes.appcrm.model.Cliente;
import com.github.oseiasarantes.appcrm.repository.ClienteRepository;
import com.github.oseiasarantes.appcrm.validator.ClienteValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteValidator validator;

    public ClienteService(ClienteRepository clienteRepository, ClienteValidator validator) {
        this.clienteRepository = clienteRepository;
        this.validator = validator;
    }

    public Cliente salvarCliente(Cliente cliente) {
        validator.vallidarClienteCadastro(cliente);

        this.clienteRepository.save(cliente);
        return cliente;
    }

    public Optional<Cliente> buscarClientePorId(UUID id) {
        return clienteRepository.findById(id);
    }
}