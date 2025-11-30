package br.com.dcext.VB_MAPP_Digital.Entities.DTOs;

import java.sql.Struct;

public record LoginResponseDTO(
        int alunoId,
        String nomeAluno,
        String email,
        String telefone,
        String matricula,
        int periodo
) {
}
