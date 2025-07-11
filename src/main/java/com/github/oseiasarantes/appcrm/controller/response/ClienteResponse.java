package com.github.oseiasarantes.appcrm.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteResponse {

    private UUID id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String ddd;
    private String telefone;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
}
