package br.com.dcext.VB_MAPP_Digital.Services.impl;


import br.com.dcext.VB_MAPP_Digital.Entities.*;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.ConsultaDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.RealizarAtividadeDTO;
import br.com.dcext.VB_MAPP_Digital.Repositories.*;
import br.com.dcext.VB_MAPP_Digital.Services.ConsultaService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ItemAtividadeRepository itemAtividadeRepository;

    @Autowired
    private ItemAtividadeRealizadoRepository itemAtividadeRealizadoRepository;

    @Override
    public Consulta criarConsulta(ConsultaDTO dto) {
        Aluno aluno = alunoRepository.findById(dto.getAlunoId()).orElseThrow();

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId()).orElseThrow();

        Consulta consulta = new Consulta();
        consulta.setAluno(aluno);
        consulta.setPaciente(paciente);
        consulta.setDataConsulta(dto.getData_consulta());


        if (!aluno.getPacientes().contains(paciente)){
            aluno.getPacientes().add(paciente);
            alunoRepository.save(aluno);
        }

        return consultaRepository.save(consulta);
    }

    @Override
    public List<Consulta> listarConsultas() {
        return consultaRepository.findAll();
    }

    @Override
    public Consulta realizarAtividade(RealizarAtividadeDTO dto) {
        Consulta consulta = consultaRepository.findById(dto.getConsultaId()).orElseThrow();

        ItemAtividade item = itemAtividadeRepository.findById(dto.getAtividadeId()).orElseThrow();


        ItemAtividadeRealizado realizada = new ItemAtividadeRealizado();
        realizada.setConsulta(consulta);
        realizada.setItem(item);
        realizada.setTentativa(dto.getTentativa());
        realizada.setPontuacaoObtida(dto.getPontuacao());


        itemAtividadeRealizadoRepository.save(realizada);
        consulta.adicionarAtividade(realizada);

        return consultaRepository.save(consulta);
    }
}
