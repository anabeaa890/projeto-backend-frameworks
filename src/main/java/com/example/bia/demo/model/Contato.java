package com.example.bia.demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contato {
    private Long id;
    private String nome;

    @Email(message = "E-mail inválido")
    private String email;

    @Pattern(regexp = "\\d{10,11}", message = "O telefone deve ter entre 10 a 11 dígitos.")
    private String telefone;

    private String snAtivo;  // S para ativo, N para inativo, F para favorito
}
