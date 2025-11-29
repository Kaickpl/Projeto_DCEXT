package br.com.dcext.VB_MAPP_Digital.Entities.DTOs;

import br.com.dcext.VB_MAPP_Digital.Entities.Aluno;
import br.com.dcext.VB_MAPP_Digital.Mappers.PacienteMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class AlunoDTO {
    private int alunoId;
    private String nomeAluno;
    private String matricula;
    private String email;
    private String telefone;
    private int periodo;
    private List<PacienteDTOs> paciente;


    public AlunoDTO() {}

    public AlunoDTO(Aluno aluno) {
        this.alunoId = aluno.getAlunoId();
        this.nomeAluno = aluno.getNomeAluno();
        this.matricula = aluno.getMatricula();
        this.email = aluno.getEmail();
        this.telefone = aluno.getTelefone();
        this.periodo = aluno.getPeriodo();
        this.paciente =new ArrayList<>();
    }
}
