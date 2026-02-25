package com.Android.Academia.model;

import com.Android.Academia.model.exercicio.ListaExercicio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "alunos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno extends User{

    //Um aluno tem varias listas
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<ListaExercicio> listaDeTreino = new ArrayList<>();
}
