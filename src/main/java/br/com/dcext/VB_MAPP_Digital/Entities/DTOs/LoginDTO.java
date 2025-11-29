package br.com.dcext.VB_MAPP_Digital.Entities.DTOs;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


public record LoginDTO(

        @NotBlank(message = "O email não pode ser vazio.")
        @Email(message = "Formato de email inválido.")
        String email,

        @NotBlank(message = "A senha não pode ser vazia.")
        String senha
) {
}
