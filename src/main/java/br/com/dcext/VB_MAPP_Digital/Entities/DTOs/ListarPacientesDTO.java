package br.com.dcext.VB_MAPP_Digital.Entities.DTOs;


import br.com.dcext.VB_MAPP_Digital.Entities.Paciente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListarPacientesDTO {
    private int idPaciente;
    private String nomePaciente;
    private String responsavel;
    private String numeroResponsavel;

    public ListarPacientesDTO() {}

    public ListarPacientesDTO(Paciente paciente) {
        this.idPaciente = paciente.getPacienteId();
        this.nomePaciente = paciente.getNomePaciente();
        this.responsavel = paciente.getResponsavel();
        this.numeroResponsavel = paciente.getNumeroResponsavel();
    }
}
