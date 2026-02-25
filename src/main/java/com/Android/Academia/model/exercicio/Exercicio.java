package com.Android.Academia.model.exercicio;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Exercicio {

    //Classe para lista de exercicio de um aluno

    private String nome;
    private int series;
    private int repeticoes;

}
