package br.com.dcext.VB_MAPP_Digital.Mappers;

import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.ListarPacientesDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.Paciente;

import java.util.List;

public class ListarPacientesDTOMapper {

    public static ListarPacientesDTO paraDTO(Paciente paciente){
        ListarPacientesDTO dto = new ListarPacientesDTO();
        dto.setIdPaciente(paciente.getPacienteId());
        dto.setNomePaciente(paciente.getNomePaciente());
        dto.setResponsavel(paciente.getResponsavel());
        dto.setNumeroResponsavel(paciente.getNumeroResponsavel());
        dto.setDataDeNascimento(paciente.getDataNascimento());
        dto.setGenero(paciente.getGenero());

        return dto;
    }
}
