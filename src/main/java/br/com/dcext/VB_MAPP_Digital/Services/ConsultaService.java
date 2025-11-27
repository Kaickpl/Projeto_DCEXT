package br.com.dcext.VB_MAPP_Digital.Services;

import br.com.dcext.VB_MAPP_Digital.Entities.Aluno;
import br.com.dcext.VB_MAPP_Digital.Entities.Consulta;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.ConsultaDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.RealizarAtividadeDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.Paciente;

import java.util.List;

public interface ConsultaService {

    Consulta criarConsulta(ConsultaDTO dto);
    List<Consulta> listarConsultasDoPaciente(Integer idPaciente);
    Consulta realizarAtividade(RealizarAtividadeDTO dto);
    Consulta buscarConsulta(Integer consultaId);
}
