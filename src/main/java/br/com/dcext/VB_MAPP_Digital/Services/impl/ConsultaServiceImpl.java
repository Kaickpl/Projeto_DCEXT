package br.com.dcext.VB_MAPP_Digital.Services.impl;


import br.com.dcext.VB_MAPP_Digital.Entities.*;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.ConsultaDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.RealizarAtividadeDTO;
import br.com.dcext.VB_MAPP_Digital.Repositories.AlunoRepository;
import br.com.dcext.VB_MAPP_Digital.Repositories.AtividadeRepository;
import br.com.dcext.VB_MAPP_Digital.Repositories.ConsultaRepository;
import br.com.dcext.VB_MAPP_Digital.Repositories.PacienteRepository;
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
    private AtividadeRepository atividadeRepository;

    @Override
    public Consulta criarConsulta(ConsultaDTO dto) {
        Aluno aluno = alunoRepository.findById(dto.getAlunoId()).orElseThrow();

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId()).orElseThrow();

        Consulta consulta = new Consulta();
        consulta.setAluno(aluno);
        consulta.setPaciente(paciente);
        consulta.setDataConsulta(dto.getData_consulta());

        return consultaRepository.save(consulta);
    }

    @Override
    public List<Consulta> listarConsultas() {
        return consultaRepository.findAll();
    }

    @Override
    public Consulta realizarAtividade(int consultaId, RealizarAtividadeDTO dto) {
        Consulta consulta = consultaRepository.findById(consultaId).orElseThrow();

        Atividade atividade = atividadeRepository.findById(dto.getAtividadeId()).orElseThrow();

        AtividadeRealizada realizada = new AtividadeRealizada();
        realizada.setAtividade(atividade);
        realizada.setPontuacao(dto.getPontuacao());

        consulta.adicionarAtividade(realizada);

        return consultaRepository.save(consulta);

    }
}
