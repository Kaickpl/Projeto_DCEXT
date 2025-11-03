package br.com.dcext.VB_MAPP_Digital.Services.impl;


import br.com.dcext.VB_MAPP_Digital.Entities.Aluno;
import br.com.dcext.VB_MAPP_Digital.Repositories.AlunoRepository;
import br.com.dcext.VB_MAPP_Digital.Services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;


    @Override
    public Aluno cadastrarAluno(Aluno aluno) {

        return alunoRepository.save(aluno);
    }

    @Override
    public boolean deletarAluno(int idAluno) {

        alunoRepository.deleteById(idAluno);

        if (alunoRepository.findById(idAluno) == null) {
            return true;
        }
        return false;
    }

    @Override
    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno atualizarAluno(int id, Aluno aluno) {

        Aluno alunoBanco = alunoRepository.findById(aluno.getId_aluno()).orElse(null);
        if (alunoBanco == null) {
            return null;
        }

        alunoBanco.setNome(aluno.getNome());
        alunoBanco.setMatricula(aluno.getMatricula());
        alunoBanco.setEmail(aluno.getEmail());
        alunoBanco.setTelefone(aluno.getTelefone());
        alunoBanco.setPeriodo(aluno.getPeriodo());
        alunoBanco.setSenha(aluno.getSenha());

        return alunoRepository.save(alunoBanco);

    }
}
