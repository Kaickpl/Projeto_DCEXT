package br.com.dcext.VB_MAPP_Digital.Mappers;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.PacienteDTOs;
import br.com.dcext.VB_MAPP_Digital.Entities.Endereco;
import br.com.dcext.VB_MAPP_Digital.Entities.Paciente;
import br.com.dcext.VB_MAPP_Digital.Services.AlunoService;
import br.com.dcext.VB_MAPP_Digital.Services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private AlunoService alunoService;

    public static PacienteDTOs paraDTO(Paciente paciente) {
        if(paciente == null) return null;

        PacienteDTOs pacienteDTOs = new PacienteDTOs();

        if(paciente.getEndereco() != null){
            pacienteDTOs.setEnderecoId(paciente.getEndereco().getIdEndereco());
        } else {
            pacienteDTOs.setEnderecoId(null);
        }

        pacienteDTOs.setIdPaciente(paciente.getPacienteId());
        pacienteDTOs.setNomePaciente(paciente.getNomePaciente());
        pacienteDTOs.setResponsavel(paciente.getResponsavel());
        pacienteDTOs.setNumeroResponsavel(paciente.getNumeroResponsavel());
        pacienteDTOs.setDataNascimento(paciente.getDataNascimento());
        pacienteDTOs.setGenero(paciente.getGenero());
        pacienteDTOs.setObservacoes(paciente.getObservacoes());
        pacienteDTOs.setAlunoId(paciente.getAluno().getAlunoId());

        return pacienteDTOs;
    }

    public Paciente paraEntity(PacienteDTOs pacienteDTOs) {
        Paciente paciente = new Paciente();
        paciente.setPacienteId(pacienteDTOs.getIdPaciente());
        paciente.setNomePaciente(pacienteDTOs.getNomePaciente());
        paciente.setResponsavel(pacienteDTOs.getResponsavel());
        paciente.setNumeroResponsavel(pacienteDTOs.getNumeroResponsavel());
        paciente.setDataNascimento(pacienteDTOs.getDataNascimento());
        paciente.setGenero(pacienteDTOs.getGenero());
        paciente.setObservacoes(pacienteDTOs.getObservacoes());
        paciente.setAluno(alunoService.buscarAlunoPorId(pacienteDTOs.getAlunoId()));

        Integer enderecoId = pacienteDTOs.getEnderecoId();

        if (enderecoId != null) {
            Endereco endereco = enderecoService.buscarEnderecoPorId(enderecoId);
            paciente.setEndereco(endereco);
        } else {
            paciente.setEndereco(null);
        }
        return paciente;
    }
}
