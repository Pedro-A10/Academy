package com.Android.Academia.model.exercicio;

import com.Android.Academia.model.Aluno;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

//Não herda de Exercicio ela apenas contem
@Getter //Não precisa dos ‘setters’ então só getters serve
@Entity
@NoArgsConstructor
public class ListaExercicio{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeTreino;

    // Uma lista de exercicios pode ter varios exercicios
    @OneToMany(mappedBy = "listaExercicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercicio> exercicios;

    //Um aluno pode ter varias listas de exercicios
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public ListaExercicio(String nomeTreino) {
        this.nomeTreino = nomeTreino;
    }

    public void adicionarExercicio(Exercicio exercicio) {
        exercicios.add(exercicio);
        exercicio.setListaExercicio(this);
    }
}
