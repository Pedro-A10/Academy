package com.Android.Academia.service;

import com.Android.Academia.enums.Funcao;
import com.Android.Academia.model.Funcionario;
import com.Android.Academia.model.User;
import com.Android.Academia.repository.FuncionarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepo funcionarioR;

    @Autowired
    private AutorizacaoService autorizacaoService;

    @Autowired
    PasswordEncoder passwordEncoder;

    /*TODO: implementar uma mapper e uma dto de funcionários
        para substituir os métodos que utilizam o funcionarioRepo diretamente.
        Criar exceptions personalizadas para os métodos que podem gerar valores incorretos
     */

    public Optional<Funcionario> findFuncionariosById(Long id) {
        return funcionarioR.findFuncionariosById(id);
    }

    public Optional<Funcionario> findFuncionariosByCPF(String cpf) {
        return funcionarioR.findFuncionariosByCPF(cpf);
    }

    public List<Funcionario> findFuncionariosByNome(String nome) {
        return funcionarioR.findFuncionariosByNome(nome);
    }

    public Optional<Funcionario> findFuncionarioByTelefone(String telefone) {
        return funcionarioR.findFuncionarioByTelefone(telefone);
    }

    public Optional<Funcionario> findAllByNome(String nome) {
        return funcionarioR.findAllByNome(nome);
    }

    public List<Funcionario> findAllByFuncao(Funcao funcao) {
        return funcionarioR.findAllByFuncao(funcao);
    }

    public boolean existsFuncionarioByEmail(String email) {
        return funcionarioR.existsFuncionarioByEmail(email);
    }

    public boolean existsFuncionarioByCPF(String cpf) {
        return funcionarioR.existsFuncionarioByCPF(cpf);
    }

    //CRUD
    public void criarFuncionario(User permitido, Funcionario novoFuncionario) throws AccessDeniedException {
        autorizacaoService.verificarPermissoes(permitido);
        funcionarioR.save(novoFuncionario);
    }
    public void deletarFuncionarioById(User permitido, Long id) throws AccessDeniedException {
        autorizacaoService.verificarPermissoes(permitido);
        Funcionario funcionario = funcionarioR.findById(id)
                .orElseThrow(() -> new ResponseStatusException
                        (HttpStatus.NOT_FOUND, "Funcionario não encontrado com id: " + id));
        funcionarioR.delete(funcionario);
    }
}
