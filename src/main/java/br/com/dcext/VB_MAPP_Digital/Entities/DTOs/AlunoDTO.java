package br.com.dcext.VB_MAPP_Digital.Entities.DTOs;

import java.util.List;

public record AlunoDTO(int alunoId,
                       String nomeAluno,
                       String matricula,
                       String email,
                       String telefone,
                       int periodo,
                       List<PacienteDTOs> pacientes) {
}
