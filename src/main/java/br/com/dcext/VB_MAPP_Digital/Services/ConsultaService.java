package br.com.dcext.VB_MAPP_Digital.Services;

import br.com.dcext.VB_MAPP_Digital.Entities.Aluno;
import br.com.dcext.VB_MAPP_Digital.Entities.Consulta;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.ConsultaDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.RealizarAtividadeDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.ResponseConsultaDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.Paciente;

import java.util.List;

public interface ConsultaService {

    ResponseConsultaDTO criarConsulta(ConsultaDTO dto);
    List<ResponseConsultaDTO> listarConsultas();
    Consulta realizarAtividade(RealizarAtividadeDTO dto);
}
