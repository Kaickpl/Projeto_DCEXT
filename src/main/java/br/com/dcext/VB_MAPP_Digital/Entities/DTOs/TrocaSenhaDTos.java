package br.com.dcext.VB_MAPP_Digital.Entities.DTOs;

import br.com.dcext.VB_MAPP_Digital.Entities.Aluno;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TrocaSenhaDTos {
    @NotBlank(message = "O email não pode ser vazio.")
    @Email(message = "Formato do email invalido")
        private String email;
    @NotBlank(message = "O campo nova senha não pode ser vazio.")
        private String novaSenha;
    @NotBlank(message = "O campo confirmar senha não pode ser vazio.")
        private String confirmaSenha;

        public TrocaSenhaDTos(Aluno aluno) {
            this.email = aluno.getEmail();
            this.novaSenha = aluno.getSenha();
            this.confirmaSenha = aluno.getSenha();
        }

}
