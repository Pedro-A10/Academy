package com.Android.Academia.model;

import com.Android.Academia.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
    //O sqlite com o jpa não tem um suporte bom

    //variáveis
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nome necessário")
    @Pattern(regexp = "^[A-Za-zÀ-ú]+(\\s[A-Za-zÀ-ú]+)+$",
            message = "Por favor colocar o nome inteiro.")
    @Column(unique = true)
    private String nome;

    @NotBlank(message = "Endereço necessário")
    private String endereco;

    @NotBlank(message = "Telefone necessário")
    private String telefone;

    @NotBlank(message = "Data de nascimento necessária")
    @Column(unique = true)
    private LocalDate nascimento;

    @NotBlank(message = "CPF é necessário")
    @CPF(message = "CPF invalido")
    @Column(unique = true)
    private String CPF;

    @NotBlank(message = "O Email é necessário")
    @Email
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "A senha é necessária")
    @Size(min = 8, max = 100, message = "A senha não pode ter menos de 8 letras!")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "A senha deve conter números e símbolos especiais.")
    @Column(unique = true)
    private String password;

    //Roles: Staff, funcionário e aluno
    private Role role;
}
