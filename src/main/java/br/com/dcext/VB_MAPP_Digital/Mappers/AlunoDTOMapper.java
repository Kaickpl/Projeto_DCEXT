package br.com.dcext.VB_MAPP_Digital.Mappers;

import br.com.dcext.VB_MAPP_Digital.Entities.Aluno;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.AlunoDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.PacienteDTOs;

import java.util.ArrayList;
import java.util.List;

public class AlunoDTOMapper {

    public static AlunoDTO paraDTO(Aluno aluno){

        List<PacienteDTOs> pacienteDTOs = new ArrayList<>();

        if (aluno.getPacientes() != null) {
            pacienteDTOs = aluno.getPacientes().stream().map(PacienteMapper::paraDTO).toList();
        }


        return new AlunoDTO(
                aluno.getAlunoId(),
                aluno.getNomeAluno(),
                aluno.getMatricula(),
                aluno.getEmail(),
                aluno.getTelefone(),
                aluno.getPeriodo(),
                pacienteDTOs

        );
    }
}
