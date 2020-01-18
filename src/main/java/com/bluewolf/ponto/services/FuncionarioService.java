package com.bluewolf.ponto.services;

import java.util.Optional;

import com.bluewolf.ponto.Repositories.FuncionarioRepository;
import com.bluewolf.ponto.models.Funcionario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService implements IFuncionarioService {

    private static final Logger log = LoggerFactory.getLogger(FuncionarioService.class);

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario persistir(Funcionario funcionario) {
        log.info("Persistindo funcionário: {}", funcionario);
        return this.funcionarioRepository.save(funcionario);
    }

    public Optional<Funcionario> buscarPorCpf(String cpf) {
        log.info("Buscando funcionário pelo CPF {}", cpf);
        return Optional.ofNullable(this.funcionarioRepository.findByCpf(cpf));
    }

    public Optional<Funcionario> buscarPorEmail(String email) {
        log.info("Buscando funcionário pelo email {}", email);
        return Optional.ofNullable(this.funcionarioRepository.findByEmail(email));
    }

    public Optional<Funcionario> buscarPorId(Long id) {
        log.info("Buscando funcionário pelo IDl {}", id);
        return this.funcionarioRepository.findById(id);
    }
}
