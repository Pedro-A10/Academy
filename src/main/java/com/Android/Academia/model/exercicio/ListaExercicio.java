package com.Android.Academia.model.exercicio;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

//Não herda de Exercicio ela apenas contem
@Getter //Não precisa dos ‘setters’ então só getters serve
public class ListaExercicio{


    private String nomeTreino;
    private List<Exercicio> exercicios;

    public ListaExercicio(String nomeTreino) {
        this.nomeTreino = nomeTreino;
        this.exercicios = new ArrayList<>();
    }

    //método para criação de ficha
    public void adicionarExercicio(Exercicio exercicio) {
        exercicios.add(exercicio);
    }
}
