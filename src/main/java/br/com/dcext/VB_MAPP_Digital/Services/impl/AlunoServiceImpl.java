package br.com.dcext.VB_MAPP_Digital.Services.impl;


import br.com.dcext.VB_MAPP_Digital.Entities.Aluno;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.AlunoDTO;
import br.com.dcext.VB_MAPP_Digital.Mappers.AlunoDTOMapper;
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
    public List<AlunoDTO> listarAlunos() {
        return alunoRepository.findAll().stream().map(AlunoDTOMapper::paraDTO).toList();
    }

    public Aluno atualizarAluno(int id, Aluno aluno) {

        Aluno alunoBanco = alunoRepository.findById(aluno.getAlunoId()).orElse(null);
        if (alunoBanco == null) {
            return null;
        }

        alunoBanco.setNomeAluno(aluno.getNomeAluno());
        alunoBanco.setMatricula(aluno.getMatricula());
        alunoBanco.setEmail(aluno.getEmail());
        alunoBanco.setTelefone(aluno.getTelefone());
        alunoBanco.setPeriodo(aluno.getPeriodo());
        alunoBanco.setSenha(aluno.getSenha());

        return alunoRepository.save(alunoBanco);

    }
}
