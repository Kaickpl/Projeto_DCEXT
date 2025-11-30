package br.com.dcext.VB_MAPP_Digital.Entities.DTOs;

import br.com.dcext.VB_MAPP_Digital.Entities.Aluno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TrocaSenhaDTos {
        private String email;
        private String novaSenha;
        private String confirmaSenha;

        public TrocaSenhaDTos(Aluno aluno) {
            this.email = aluno.getEmail();
            this.novaSenha = aluno.getSenha();
            this.confirmaSenha = aluno.getSenha();
        }

}
