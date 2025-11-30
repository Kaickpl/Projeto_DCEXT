package br.com.dcext.VB_MAPP_Digital.Mappers;

import br.com.dcext.VB_MAPP_Digital.Entities.Aluno;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.AlunoDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.PacienteDTOs;

import java.util.ArrayList;
import java.util.List;

public class AlunoDTOMapper {

    public static AlunoDTO paraDTO(Aluno aluno){
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setAlunoId(aluno.getAlunoId());
        alunoDTO.setNomeAluno(aluno.getNomeAluno());
        alunoDTO.setMatricula(aluno.getMatricula());
        alunoDTO.setEmail(aluno.getEmail());
        alunoDTO.setTelefone(aluno.getTelefone());
        alunoDTO.setPeriodo(aluno.getPeriodo());


        if (aluno.getPacientes() != null) {
            alunoDTO.setPaciente(aluno.getPacientes().stream().map(PacienteMapper::paraDTO).toList());
        }


        return alunoDTO;
    }
}
