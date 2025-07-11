package com.github.oseiasarantes.appcrm.validator;

import com.github.oseiasarantes.appcrm.exceptions.RegistroDuplicadoException;
import com.github.oseiasarantes.appcrm.model.Cliente;
import com.github.oseiasarantes.appcrm.repository.ClienteRepository;
import org.springframework.stereotype.Component;

import static com.github.oseiasarantes.appcrm.exceptions.enums.ExceptionEnum.CLIENTE_CADASTRADO;

@Component
public class ClienteValidator {

    private final ClienteRepository clienteRepository;

    public ClienteValidator(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void vallidarClienteCadastro(Cliente cliente) {
        if (clienteRepository.existsByCpf(cliente.getCpf()))
            throw new RegistroDuplicadoException(CLIENTE_CADASTRADO.getMessage());
    }
}
