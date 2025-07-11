package com.github.oseiasarantes.appcrm.controller.response;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;


public record ErroResponse (Integer status, String message, List<ErroCampo> erros) {

    public static ErroResponse notFoundResponse(String mensagem) {
        return new ErroResponse(NOT_FOUND.value(), mensagem, List.of());
    }

    public static ErroResponse badRequestResponse(String mensagem) {
        return new ErroResponse(BAD_REQUEST.value(), mensagem, List.of());
    }
}