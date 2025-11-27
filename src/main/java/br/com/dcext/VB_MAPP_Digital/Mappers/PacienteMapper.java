package br.com.dcext.VB_MAPP_Digital.Mappers;

import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.EnderecoDTOs;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.PacienteDTOs;
import br.com.dcext.VB_MAPP_Digital.Entities.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteMapper {

    public static PacienteDTOs paraDTO(Paciente paciente){

        return new PacienteDTOs(
                paciente.getPacienteId(),
                paciente.getNomePaciente(),
                paciente.getResponsavel(),
                paciente.getNumeroResponsavel(),
                paciente.getDataNascimento(),
                paciente.getGenero(),
                paciente.getObservacoes(),
                paciente.getEndereco()
        );
    }
}
