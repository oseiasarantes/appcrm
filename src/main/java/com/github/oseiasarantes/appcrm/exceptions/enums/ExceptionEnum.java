package com.github.oseiasarantes.appcrm.exceptions.enums;

import lombok.Getter;

@Getter
public enum ExceptionEnum {

    CLIENTE_CADASTRADO("Cliente informado já encontra-se cadastrado."),
    CLIENTE_NAO_ENCONTRADO("Cliente informado não encontrado."),
    ERRO_INTERNO("Erro interno no sistema. Entre em contato com a administração"),
    ERRO_VALIDACAO_CAMPO("Erro de validação de campo");

    private final String message;

    ExceptionEnum(String message) {
        this.message = message;
    }
}
