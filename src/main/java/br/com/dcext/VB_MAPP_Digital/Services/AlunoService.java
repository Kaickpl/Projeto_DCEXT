package br.com.dcext.VB_MAPP_Digital.Services;


import br.com.dcext.VB_MAPP_Digital.Entities.Aluno;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.AlunoDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.RegisterDTO;

import java.util.List;

public interface AlunoService {
    Aluno cadastrarAluno(RegisterDTO dto);
    boolean deletarAluno(int idAluno);
    List<AlunoDTO> listarAlunos();
    Aluno atualizarAluno(int id, Aluno aluno);
    Aluno buscarAlunoPorId(Integer idAluno);
}
