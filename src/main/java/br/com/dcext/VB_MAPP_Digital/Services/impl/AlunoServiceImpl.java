package br.com.dcext.VB_MAPP_Digital.Services.impl;


import br.com.dcext.VB_MAPP_Digital.Entities.Aluno;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.*;
import br.com.dcext.VB_MAPP_Digital.Mappers.AlunoDTOMapper;
import br.com.dcext.VB_MAPP_Digital.Repositories.AlunoRepository;
import br.com.dcext.VB_MAPP_Digital.Services.AlunoService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;


    @Override
    public Aluno cadastrarAluno(RegisterDTO dto) {

        Aluno aluno = new Aluno();
        aluno.setNomeAluno(dto.nomeAluno());
        aluno.setMatricula(dto.matricula());
        aluno.setEmail(dto.email());
        aluno.setTelefone(dto.telefone());
        aluno.setSenha(dto.senha());
        aluno.setPeriodo(dto.periodo());

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
    public Aluno buscarAlunoPorId(Integer idAluno){
        return alunoRepository.findById(idAluno).get();
    }

    @Override
    public Aluno trocarSenha(TrocaSenhaDTos senhaDTOs) {
        Optional<Aluno> aluno = alunoRepository.findByEmail(senhaDTOs.getEmail());
        if (aluno.isEmpty()) {
            return null;
        }
        if (senhaDTOs.getNovaSenha() == null || senhaDTOs.getNovaSenha().isBlank() ||
                senhaDTOs.getConfirmaSenha() == null || senhaDTOs.getConfirmaSenha().isBlank()) {
            return null;

        }if(!senhaDTOs.getNovaSenha().equals(senhaDTOs.getConfirmaSenha())){
            return null;
        }

        if (senhaDTOs.getNovaSenha().equals(aluno.get().getSenha())) {
            return null;
        }
        Aluno alunoEncontrado = aluno.get();
        alunoEncontrado.setSenha(senhaDTOs.getConfirmaSenha());
        return alunoRepository.save(alunoEncontrado);


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

    public LoginResponseDTO login(LoginDTO dto) {
        var aluno = alunoRepository.findByEmail(dto.email())
                .orElseThrow(() -> new RuntimeException("Email inválido."));

        if (!aluno.getSenha().equals(dto.senha())) {
            throw new RuntimeException("Senha incorreta.");
        }

        return new LoginResponseDTO(
                aluno.getAlunoId(),
                aluno.getNomeAluno(),
                aluno.getEmail(),
                aluno.getTelefone(),
                aluno.getMatricula(),
                aluno.getPeriodo()
        );

    }
}
