package com.github.oseiasarantes.appcrm.controller.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {

    @NotBlank(message = "Nome não pode estar em branco")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "O CPF não pode estar em branco")
    @CPF(message = "CPF informado em inválido")
    private String cpf;

    @NotNull(message = "A data de nascimento não pode ser nula")
    @Past(message = "A data de nasicmento não pode ser uma data futura")
    private LocalDate dataNascimento;

    @Email(message = "Formato de e-mail inválido")
    @Size(max = 50, message = "O e-mail deve ter no máximo 50 caracteres")
    private String email;

    @NotBlank(message = "O DDD não pode estar em branco")
    @Size(min = 2, max = 3, message = "O DDD deve ter entre 2 e 3 caracteres")
    private String ddd;

    @NotBlank(message = "O telefone não pode estar em branco")
    @Size(min = 8, max = 15, message = "O telefone deve ter entre 8 e 15 caracteres")
    private String telefone;

    @Size(max = 50, message = "O endereço deve ter no máximo 50 caracteres")
    private String endereco;

    @Size(max = 50, message = "O bairro deve ter no máximo 50 caracteres")
    private String bairro;

    @Size(max = 50, message = "A cidade deve ter no máximo 50 caracteres")
    private String cidade;

    @Size(max = 2, message = "A UF deve ter no máximo 2 caracteres")
    private String uf;

    @Size(max = 8, message = "O CEP deve ter no máximo 8 dígitos")
    private String cep;
}
