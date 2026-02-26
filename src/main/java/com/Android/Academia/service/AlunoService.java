package com.Android.Academia.service;

import com.Android.Academia.model.Aluno;
import com.Android.Academia.model.User;
import com.Android.Academia.repository.AlunoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepo alunoR;

    @Autowired
    private AutorizacaoService autorizacaoService;

    /*TODO: implementar uma mapper e uma dto de alunos
        para substituir os métodos que utilizam o AlunoRepo diretamente.
        Criar exceptions personalizadas para os métodos que podem gerar valores incorretos
     */

    //hashing de senhas usar só depois de criar os dto e mapper
    @Autowired
    PasswordEncoder passwordEncoder;

    //Get
    public Optional<Aluno> findAlunosById(Long id) {
        return alunoR.findAlunosById(id);
    }

    public Optional<Aluno> findAlunosByCPF(String cpf) {
        return alunoR.findAlunosByCPF(cpf);
    }

    public Optional<Aluno> findAlunosByEmail(String email) {
        return alunoR.findAlunosByEmail(email);
    }

    public List<Aluno> findAlunosByNome(String nome) {
        return alunoR.findAlunosByNome(nome);
    }

    public List<Aluno> findAlunosByTelefone(String telefone) {
        return alunoR.findAlunosByTelefone(telefone);
    }

    //Booleans
    public boolean existsAlunosByEmail(String email) {
        return alunoR.existsAlunosByEmail(email);
    }

    public boolean existsAlunosByCPF(String cpf) {
        return alunoR.existsAlunosByCPF(cpf);
    }

    //Operações de CRUD (CREATE / DELETE)
    public void criarAluno(User permitido, Aluno novoAluno) throws AccessDeniedException {
        autorizacaoService.verificarPermissoes(permitido);
        alunoR.save(novoAluno);
    }

    public void deletarAlunoById(User permitido, Long id) throws AccessDeniedException {
        autorizacaoService.verificarPermissoes(permitido);
        Aluno aluno = alunoR.findById(id)
                .orElseThrow(() -> new ResponseStatusException
                        (HttpStatus.NOT_FOUND, "Aluno não encontrado com id: " + id));
        alunoR.delete(aluno);
    }
}
