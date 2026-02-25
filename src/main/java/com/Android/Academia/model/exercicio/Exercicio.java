package com.Android.Academia.model.exercicio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int series;
    private int repeticoes;

    //Muitos exercicios podem estar em uma lista
    @ManyToOne
    @JoinColumn(name = "lista_id")
    private ListaExercicio listaExercicio;

    //Construtor para montar lista
    public Exercicio(String nome, int series, int repeticoes) {
        this.nome = nome;
        this.series = series;
        this.repeticoes = repeticoes;
    }
}
