package com.Android.Academia.repository;

import com.Android.Academia.enums.Funcao;
import com.Android.Academia.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepo extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findFuncionariosById(Long id);

    Optional<Funcionario> findFuncionariosByCPF(String cpf);

    List<Funcionario> findFuncionariosByNome(String nome);

    Optional<Funcionario> findFuncionarioByTelefone(String telefone);

    Optional<Funcionario> findAllByNome(String nome);

    //Procura via Enum
    List<Funcionario> findAllByFuncao(Funcao funcao);

    boolean existsFuncionarioByEmail(String email);
    boolean existsFuncionarioByCPF(String cpf);

}
