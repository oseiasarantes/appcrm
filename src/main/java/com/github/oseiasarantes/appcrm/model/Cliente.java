package com.github.oseiasarantes.appcrm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "cliente", schema = "public")
@Data
public class Cliente {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ds_nome")
    private String nome;

    @Column(name = "ds_cpf")
    private String cpf;

    @Column(name = "dt_nascimento")
    private Date dataNascimento;

    @Column(name = "ds_email")
    private String email;

    @Column(name = "ds_ddd")
    private String ddd;

    @Column(name = "ds_telefone")
    private String telefone;

    @Column(name = "ds_endereco")
    private String endereco;

    @Column(name = "ds_bairro")
    private String bairro;

    @Column(name = "ds_cidade")
    private String cidade;

    @Column(name = "ds_uf")
    private String uf;

    @Column(name = "ds_cep")
    private String cep;
}