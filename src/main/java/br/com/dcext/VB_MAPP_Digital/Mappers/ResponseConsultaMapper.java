package br.com.dcext.VB_MAPP_Digital.Mappers;

import br.com.dcext.VB_MAPP_Digital.Entities.Consulta;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.ItemAtividadeRealizadoDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.ResponseConsultaDTO;

import java.util.List;

public class ResponseConsultaMapper {

    public static ResponseConsultaDTO paraDTO(Consulta consulta){

        List<ItemAtividadeRealizadoDTO> atividadeDTO = consulta.getAtividades()
                .stream()
                .map(ItemAtividadeRealizadoDTOMapper::paraDTO)
                .toList();


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
                atividadeDTO,
                consulta.getRelatorio()
        );
    }
}
