package br.com.dcext.VB_MAPP_Digital.Services;

import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.PacienteDTOs;
import br.com.dcext.VB_MAPP_Digital.Entities.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PacienteService {


    List<Paciente> listarPacientes();
    Paciente cadastrarPaciente(PacienteDTOs pacienteDto);
    boolean deletarPaciente(int idPaciente);
    List<Paciente> listarPacienteNome(String nome);
    Paciente editarPaciente(int pacienteId, PacienteDTOs paciente);
    Page<Paciente> ListarAlunos(Pageable page);
    Paciente buscarPaciente(int idPaciente);

}
