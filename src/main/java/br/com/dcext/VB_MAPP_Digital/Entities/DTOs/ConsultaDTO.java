package br.com.dcext.VB_MAPP_Digital.Entities.DTOs;

import br.com.dcext.VB_MAPP_Digital.Entities.Aluno;
import br.com.dcext.VB_MAPP_Digital.Entities.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
public class ConsultaDTO {
    private int alunoId;
    private int pacienteId;
    Date data_consulta;

    public ConsultaDTO(int alunoId, int pacienteId, Date data_consulta) {
        this.alunoId = alunoId;
        this.pacienteId = pacienteId;
        this.data_consulta = new Date();
    }
}
