package br.com.dcext.VB_MAPP_Digital.Services;


import br.com.dcext.VB_MAPP_Digital.Entities.Aluno;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.AlunoDTO;

import java.util.List;

public interface AlunoService {
    Aluno cadastrarAluno(Aluno aluno);
    boolean deletarAluno(int idAluno);
    List<AlunoDTO> listarAlunos();
    Aluno atualizarAluno(int id, Aluno aluno);
}
