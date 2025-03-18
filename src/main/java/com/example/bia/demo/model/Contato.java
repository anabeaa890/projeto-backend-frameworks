package com.example.bia.demo.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contato {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Email
    private String email;

    @Pattern(regexp = "\\d{10,11}", message = "O telefone deve ter entre 10 a 11 dígitos.")
    private String telefone;

    private String snAtivo;  // Assegure-se que isso tenha um getter e setter
}