package br.com.dcext.VB_MAPP_Digital.Services.impl;

import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.PacienteDTOs;
import br.com.dcext.VB_MAPP_Digital.Entities.Paciente;
import br.com.dcext.VB_MAPP_Digital.Repositories.PacienteRepository;
import br.com.dcext.VB_MAPP_Digital.Services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;


    @Override
    public Paciente cadastrarPaciente(PacienteDTOs pacienteDTOs) {
        if  (pacienteDTOs.getNome() == null || pacienteDTOs.getNome().isBlank()){
            return  null;
        }
        if (pacienteDTOs.getResponsavel() == null || pacienteDTOs.getResponsavel().isBlank()){
            return  null;
        }
        if (pacienteDTOs.getNumeroResponsavel() == null || pacienteDTOs.getNumeroResponsavel().isBlank()){
            return  null;
        }
        if (pacienteDTOs.getDataNascimento() == null || pacienteDTOs.getDataNascimento().isBlank()){
            return  null;
        }
        if (pacienteDTOs.getEndereco() == null){
            return  null;
        }
        Paciente paciente = cadastrarPaciente(pacienteDTOs);
        return pacienteRepository.save(paciente);
        }


    @Override
    public boolean deletarPaciente(int idPaciente) {
        Optional<Paciente> paciente = pacienteRepository.findById(idPaciente);
        if (paciente.isEmpty()) {
            return false;
        }
        pacienteRepository.delete(paciente.get());
        return false;
    }

    @Override
    public List<Paciente> listarPaciente(String nome) {
        if  (nome == null || nome.isBlank()){
            return null;
        }
        List<Paciente> pacientes = pacienteRepository.findByNomeContainsIgnoreCase(nome);
        if (pacientes.isEmpty()) {
            return null;
        }
        return pacientes;
    }

    @Override
    public Paciente editarPaciente(int idPaciente, Paciente paciente) {
        return null;
    }

    @Override
    public Page<Paciente> ListarAlunos(Pageable page) {
        Page<Paciente> paciente = pacienteRepository.findAll(page);
        if (paciente == null) {
            return null;
        }
        return pacienteRepository.findAll(page);

    }

    private Paciente converterPacienteDTO(PacienteDTOs pacienteDTOs) {
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteDTOs.getNome());
        paciente.setResponsavel(pacienteDTOs.getResponsavel());
        paciente.setNumeroResponsavel(pacienteDTOs.getNumeroResponsavel());
        paciente.setEndereco(pacienteDTOs.getEndereco());
        paciente.setIdPaciente(pacienteDTOs.getIdPaciente());
        paciente.setDataNascimento(pacienteDTOs.getDataNascimento());
        paciente.setGenero(pacienteDTOs.getGenero());
        paciente.setObservacoes(pacienteDTOs.getObservacoes());
        return paciente;
    }
}
