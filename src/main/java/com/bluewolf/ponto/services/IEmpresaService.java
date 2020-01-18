package com.bluewolf.ponto.services;

import com.bluewolf.ponto.models.Empresa;

import java.util.Optional;

public interface IEmpresaService {
    Optional<Empresa> buscarPorCnpj(String cnpj);
    Empresa persistir(Empresa empresa);
}
