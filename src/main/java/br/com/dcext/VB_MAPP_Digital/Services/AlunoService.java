package br.com.dcext.VB_MAPP_Digital.Services;


import br.com.dcext.VB_MAPP_Digital.Entities.Aluno;

import java.util.List;

public interface AlunoService {
    Aluno cadastrarAluno(Aluno aluno);
    boolean deletarAluno(int idAluno);
    List<Aluno> listarAlunos();
    Aluno atualizarAluno(int id, Aluno aluno);
}
