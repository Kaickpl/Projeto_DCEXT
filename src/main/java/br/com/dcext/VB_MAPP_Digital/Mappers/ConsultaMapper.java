package br.com.dcext.VB_MAPP_Digital.Mappers;

import br.com.dcext.VB_MAPP_Digital.Entities.Consulta;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.ResponseConsultaDTO;

public class ConsultaMapper {

    public static ResponseConsultaDTO paraDTO(Consulta consulta){
        return new ResponseConsultaDTO(
                consulta.getConsultaId(),
                consulta.getAluno().getAlunoId(),
                consulta.getAluno().getNomeAluno(),
                consulta.getAluno().getMatricula(),
                consulta.getAluno().getTelefone(),
                consulta.getAluno().getPeriodo(),
                consulta.getPaciente().getPacienteId(),
                consulta.getPaciente().getNomePaciente(),
                consulta.getPaciente().getResponsavel(),
                consulta.getPaciente().getNomePaciente(),
                consulta.getPaciente().getObservacoes(),
                consulta.getDataConsulta(),
                consulta.getPontuacaoTotal(),
                consulta.getAtividades(),
                consulta.getRelatorio()
        );
    }
}
