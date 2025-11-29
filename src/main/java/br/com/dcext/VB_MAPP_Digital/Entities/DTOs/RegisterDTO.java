package br.com.dcext.VB_MAPP_Digital.Entities.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RegisterDTO(

        @NotBlank(message = "O nome não pode ser vazio.")
        String nomeAluno,

        @NotBlank(message = "A matrícula não pode ser vazia.")
        @Pattern(
                regexp = "^\\d{9}$",
                message = "Formato inválido de matrícula.")
        String matricula,

        @NotBlank(message = "O email não pode ser vazio.")
        @Email(message = "Formato inválido de email.")
        String email,

        @NotBlank(message = "O telefone não pode ser vazio.")
        @Pattern(
                regexp = "^\\d{10,11}$",
                message = "Formado de telefone inválido"
        )
        String telefone,

        @NotBlank(message = "A senha não pode ser vazia.")
        String senha,

        @NotNull(message = "O periodo não pode ser vazio.")
        Integer periodo) {}
