package com.github.oseiasarantes.appcrm.controller.mappers;

import com.github.oseiasarantes.appcrm.controller.request.ClienteRequest;
import com.github.oseiasarantes.appcrm.controller.response.ClienteResponse;
import com.github.oseiasarantes.appcrm.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Qualifier;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toEntity(ClienteRequest request);

    ClienteResponse toResponse(Cliente cliente);

}
