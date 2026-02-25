package com.Android.Academia.model;

import com.Android.Academia.enums.Funcao;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Entity(name = "funcionario")
@NoArgsConstructor
public class Funcionario extends User{

    private Funcao funcao;
    private BigDecimal salario;
}
