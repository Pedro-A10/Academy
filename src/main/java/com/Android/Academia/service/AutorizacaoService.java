package com.Android.Academia.service;

import com.Android.Academia.enums.Funcao;
import com.Android.Academia.enums.Role;
import com.Android.Academia.model.Funcionario;
import com.Android.Academia.model.User;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;

@Service
public class AutorizacaoService {

    //Metodo auxiliar para permissões de CRUD
    public void verificarPermissoes(User permitido) throws AccessDeniedException {
        //Permissão para staff
        if (permitido.getRole() == Role.STAFF) {
            return;
        }
        //permissão para recpção
        if (permitido instanceof Funcionario funcionario &&
                funcionario.getFuncao() == Funcao.RECEPCAO) {
            return;
        }
        throw new AccessDeniedException("Sem permissão para gerenciar aluno");
    }
}
