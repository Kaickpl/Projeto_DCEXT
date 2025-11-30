package br.com.dcext.VB_MAPP_Digital.Services;

import br.com.dcext.VB_MAPP_Digital.Entities.Aluno;
import br.com.dcext.VB_MAPP_Digital.Entities.Consulta;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.ConsultaDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.RealizarAtividadeDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.ResponseConsultaDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.Paciente;

import java.util.List;

public interface ConsultaService {

//<<<<<<< HEAD
//    ResponseConsultaDTO criarConsulta(ConsultaDTO dto);
//    List<ResponseConsultaDTO> listarConsultas();
//=======
        ResponseConsultaDTO criarConsulta(ConsultaDTO dto);
    List<ResponseConsultaDTO> listarConsultas();
//>>>>>>> ab51fc45a58beba292c3b21529bce0be9a760b63
    ResponseConsultaDTO realizarAtividade(RealizarAtividadeDTO dto);
    Consulta buscarConsulta(Integer consultaId);
    ResponseConsultaDTO relatorioConsultaId(int consultaId);
}
