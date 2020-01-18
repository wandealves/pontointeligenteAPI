package com.bluewolf.ponto.services;

import com.bluewolf.ponto.Repositories.EmpresaRepository;
import com.bluewolf.ponto.models.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmpresaService implements IEmpresaService {
    private static final Logger log = LoggerFactory.getLogger(EmpresaService.class);

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Optional<Empresa> buscarPorCnpj(String cnpj) {
        log.info("Buscando uma empresa para o CNPJ {}", cnpj);

        return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
    }

    @Override
    public Empresa persistir(Empresa empresa) {
        log.info("Persistindo empresa: {}", empresa);

        return empresaRepository.save(empresa);
    }
}
