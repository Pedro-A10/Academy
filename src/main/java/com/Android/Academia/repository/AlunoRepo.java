package com.Android.Academia.repository;

import com.Android.Academia.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlunoRepo extends JpaRepository<Aluno, Long> {

    Optional<Aluno> findAlunosById(Long id);

    Optional<Aluno> findAlunosByCPF(String cpf);

    Optional<Aluno> findAlunosByEmail(String email);

    List<Aluno> findAlunosByNome(String nome);

    List<Aluno> findAlunosByTelefone(String telefone);

    boolean existsAlunosByEmail(String email);
    boolean existsAlunosByCPF(String cpf);

}
