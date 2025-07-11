package com.github.oseiasarantes.appcrm.controller.common;

import com.github.oseiasarantes.appcrm.controller.response.ErroCampo;
import com.github.oseiasarantes.appcrm.controller.response.ErroResponse;
import com.github.oseiasarantes.appcrm.exceptions.OperacaoNaoPermitidaException;
import com.github.oseiasarantes.appcrm.exceptions.RegistroNaoEncontradoException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static com.github.oseiasarantes.appcrm.controller.response.ErroResponse.badRequestResponse;
import static com.github.oseiasarantes.appcrm.controller.response.ErroResponse.notFoundResponse;
import static com.github.oseiasarantes.appcrm.exceptions.enums.ExceptionEnum.ERRO_INTERNO;
import static com.github.oseiasarantes.appcrm.exceptions.enums.ExceptionEnum.ERRO_VALIDACAO_CAMPO;
import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErroResponse handleMethodNotValidException(MethodArgumentNotValidException exception) {
        List<FieldError> erros = exception.getFieldErrors();

        List<ErroCampo> erroCampoList = erros
                .stream()
                .map( fe -> new ErroCampo(fe.getField(), fe.getDefaultMessage())).toList();

        return new ErroResponse(BAD_REQUEST.value(), ERRO_VALIDACAO_CAMPO.getMessage(), erroCampoList);
    }

    @ExceptionHandler(OperacaoNaoPermitidaException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErroResponse handleExceptionBadRequest(RuntimeException e) {
        return badRequestResponse(e.getMessage());
    }

    @ExceptionHandler(RegistroNaoEncontradoException.class)
    @ResponseStatus(NOT_FOUND)
    public ErroResponse handleExceptionNotFound(RuntimeException e) {
        return notFoundResponse(e.getMessage());
    }

    //TODO retirar tratamento de erro 500 quando ajustar log
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(INTERNAL_SERVER_ERROR)
//    public ErroResponse handleGenericException(RuntimeException e) {
//        return new ErroResponse(INTERNAL_SERVER_ERROR.value(), ERRO_INTERNO.getMessage(), List.of());
//    }
}
