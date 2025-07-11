package com.github.oseiasarantes.appcrm.controller;

import com.github.oseiasarantes.appcrm.controller.mappers.ClienteMapper;
import com.github.oseiasarantes.appcrm.controller.request.ClienteRequest;
import com.github.oseiasarantes.appcrm.controller.response.ClienteResponse;
import com.github.oseiasarantes.appcrm.exceptions.RegistroNaoEncontradoException;
import com.github.oseiasarantes.appcrm.model.Cliente;
import com.github.oseiasarantes.appcrm.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

import static com.github.oseiasarantes.appcrm.exceptions.enums.ExceptionEnum.CLIENTE_NAO_ENCONTRADO;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteMapper mapper;

    public ClienteController(ClienteService clienteService, ClienteMapper mapper) {
        this.clienteService = clienteService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> salvarCliente(@RequestBody @Valid ClienteRequest request) {
        Cliente cliente = mapper.toEntity(request);
        cliente = clienteService.salvarCliente(cliente);

        ClienteResponse response = mapper.toResponse(cliente);
        return ResponseEntity.status(CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> buscaClientePorId(@PathVariable UUID id){
        Optional<Cliente> clienteOptional = clienteService.buscarClientePorId(id);

        if (clienteOptional.isEmpty()) {
            throw new RegistroNaoEncontradoException(CLIENTE_NAO_ENCONTRADO.getMessage());
        }

        ClienteResponse response = mapper.toResponse(clienteOptional.get());
        return ResponseEntity.ok().body(response);
    }
}
