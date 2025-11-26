package br.com.dcext.VB_MAPP_Digital.Services.impl;

import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.PacienteDTOs;
import br.com.dcext.VB_MAPP_Digital.Entities.Endereco;
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
    public Paciente cadastrarPaciente(Paciente paciente) {
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


    public List<Paciente> listarPacientes(){
        return pacienteRepository.findAll();
    }


    @Override
    public List<Paciente> listarPacienteNome(String nome) {
        return pacienteRepository.findByNomeContainsIgnoreCase(nome);
    }

    @Override
    public Paciente editarPaciente(int pacienteId, Paciente paciente) {
        Optional<Paciente> idExiste = pacienteRepository.findById(pacienteId);
        if (idExiste.isEmpty()) {
            return null;
        }
        Paciente PacienteEncontrado = idExiste.get();
        if (paciente.getNome() != null) {
            if (paciente.getNome().isBlank()) {
                return null;
            }
            PacienteEncontrado.setNome(paciente.getNome());
        }
        if (paciente.getNumeroResponsavel() != null) {

            if (paciente.getNumeroResponsavel().isBlank()) {
                return null;
            }
            PacienteEncontrado.setNumeroResponsavel(paciente.getNumeroResponsavel());;
        }
        if (paciente.getDataNascimento() != null) {
            if (PacienteEncontrado.getDataNascimento()!= null){
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

    private Paciente converterPacienteDTO(PacienteDTOs pacienteDTOs) {
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteDTOs.getNome());
        paciente.setResponsavel(pacienteDTOs.getResponsavel());
        paciente.setNumeroResponsavel(pacienteDTOs.getNumeroResponsavel());
        paciente.setPacienteId(pacienteDTOs.getIdPaciente());
        paciente.setDataNascimento(pacienteDTOs.getDataNascimento());
        paciente.setGenero(pacienteDTOs.getGenero());
        paciente.setObservacoes(pacienteDTOs.getObservacoes());
        if (pacienteDTOs.getEnderecoDTOs() != null) {
            Endereco endereco = new Endereco();
            endereco.setRua(pacienteDTOs.getEnderecoDTOs().getRua());
            endereco.setNumero(pacienteDTOs.getEnderecoDTOs().getNumero());
            endereco.setBairro(pacienteDTOs.getEnderecoDTOs().getBairro());
            endereco.setCidade(pacienteDTOs.getEnderecoDTOs().getCidade());
            endereco.setEstado(pacienteDTOs.getEnderecoDTOs().getEstado());
            paciente.setEndereco(endereco);
        }
        return paciente;
    }
}
