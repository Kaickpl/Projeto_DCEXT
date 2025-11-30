package br.com.dcext.VB_MAPP_Digital.Services.impl;

import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.PacienteDTOs;
import br.com.dcext.VB_MAPP_Digital.Entities.Endereco;
import br.com.dcext.VB_MAPP_Digital.Entities.Paciente;
import br.com.dcext.VB_MAPP_Digital.Mappers.PacienteMapper;
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

    @Autowired
    private PacienteMapper pacienteMapper;

    @Override
    public Paciente cadastrarPaciente(Paciente paciente) {
        Paciente entidade = (paciente);
//        if  (pacienteDTOs.getNome() == null || pacienteDTOs.getNome().isBlank()){
//            return  null;
//        }
//        if (pacienteDTOs.getResponsavel() == null || pacienteDTOs.getResponsavel().isBlank()){
//            return  null;
//        }
//        if (pacienteDTOs.getNumeroResponsavel() == null || pacienteDTOs.getNumeroResponsavel().isBlank()){
//            return  null;
//        }
//        if (pacienteDTOs.getDataNascimento() == null || pacienteDTOs.getDataNascimento().isBlank()){
//            return  null;
//        }
//        if (pacienteDTOs.getEndereco() == null){
//            return  null;
//        }
//        Paciente paciente = cadastrarPaciente(pacienteDTOs);
        return pacienteRepository.save(entidade);
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


    public List<Paciente> listarPacientes(){
        return pacienteRepository.findAll();
    }


    @Override
    public List<Paciente> listarPacienteNome(String nome) {
        return pacienteRepository.findByNomePacienteContainsIgnoreCase(nome);
    }

    @Override
    public Paciente editarPaciente(int pacienteId, PacienteDTOs paciente) {
        Optional<Paciente> idExiste = pacienteRepository.findById(pacienteId);
        if (idExiste.isEmpty()) {
            return null;
        }
        Paciente PacienteEncontrado = idExiste.get();
        if (paciente.getNomePaciente() != null) {
            if (paciente.getNomePaciente().isBlank()) {
                return null;
            }
            PacienteEncontrado.setNomePaciente(paciente.getNomePaciente());
        }
        if (paciente.getNumeroResponsavel() != null) {

            if (paciente.getNumeroResponsavel().isBlank()) {
                return null;
            }
            PacienteEncontrado.setNumeroResponsavel(paciente.getNumeroResponsavel());;
        }
        if (paciente.getDataNascimento() != null) {
            if (paciente.getDataNascimento().isBlank()){
                return null;
            }
            PacienteEncontrado.setDataNascimento(paciente.getDataNascimento());
        }
        if (paciente.getResponsavel() != null) {
            if (paciente.getResponsavel().isBlank()) {
                return null;
            }
            PacienteEncontrado.setResponsavel(paciente.getResponsavel());
        }

        return pacienteRepository.save(PacienteEncontrado);

    }

    @Override
    public Page<Paciente> ListarAlunos(Pageable page) {
        Page<Paciente> paciente = pacienteRepository.findAll(page);
        if (paciente == null) {
            return null;
        }
        return pacienteRepository.findAll(page);

    }

    @Override
    public List<Paciente> buscarPacientesPorAluno(int idAluno) {
        return pacienteRepository.findByIdDoAluno(idAluno);
    }

    @Override
    public Paciente buscarPaciente(int idPaciente) {
        return pacienteRepository.findById(idPaciente).get();
    }
}
