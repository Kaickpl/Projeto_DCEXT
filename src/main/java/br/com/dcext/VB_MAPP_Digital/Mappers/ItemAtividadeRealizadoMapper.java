package br.com.dcext.VB_MAPP_Digital.Mappers;
import br.com.dcext.VB_MAPP_Digital.Entities.Consulta;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.AtividadeRealizadaResponseDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.RealizarAtividadeDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.ItemAtividade;
import br.com.dcext.VB_MAPP_Digital.Entities.ItemAtividadeRealizado;
import br.com.dcext.VB_MAPP_Digital.Entities.Paciente;
import br.com.dcext.VB_MAPP_Digital.Services.ConsultaService;
import br.com.dcext.VB_MAPP_Digital.Services.ItemAtividadeService;
import br.com.dcext.VB_MAPP_Digital.Services.PacienteService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
@Getter
@Setter
public class ItemAtividadeRealizadoMapper {

    @Autowired
    ItemAtividadeService itemAtividadeService;

    @Autowired
    ConsultaService consultaService;

    @Autowired
    PacienteService pacienteService;

    public AtividadeRealizadaResponseDTO toReponseDTO(ItemAtividadeRealizado itemAtividade){
        if(itemAtividade == null){
            return null;
        }

        final Consulta consulta = itemAtividade.getConsulta();
        final ItemAtividade item = itemAtividade.getItem();
        final Paciente paciente = consulta != null ? consulta.getPaciente() : null;

        AtividadeRealizadaResponseDTO responseDTO = new AtividadeRealizadaResponseDTO();

        responseDTO.setIdAtividadeRealizada(itemAtividade.getId());

        if(consulta != null){
            responseDTO.setConsultaId(consulta.getConsultaId());
        }

        if(item != null){
            responseDTO.setItemAtividadeId(itemAtividade.getItem().getId());
            responseDTO.setItemAtividadeTitulo(itemAtividade.getItem().getTitulo());
        }

        if(paciente != null){
            responseDTO.setPaciente(paciente.getNomePaciente());
        } else {
            responseDTO.setPaciente("Não disponível");
        }

        responseDTO.setPontuacaoStatus(itemAtividade.getPontuacaoAlcancada());
        responseDTO.setPontuacaoValor(itemAtividade.getPontuacaoAlcancada().getValor());
        responseDTO.setTentativas(itemAtividade.getTentativa());

        return  responseDTO;
    }

    public ItemAtividadeRealizado toEntity(RealizarAtividadeDTO dto){
        ItemAtividadeRealizado itemAtividadeRealizado = new ItemAtividadeRealizado();
        itemAtividadeRealizado.setItem(itemAtividadeService.buscarItemAtividadePorId(dto.getAtividadeId()));
        itemAtividadeRealizado.setConsulta(consultaService.buscarConsulta(dto.getConsultaId()));

        itemAtividadeRealizado.setPontuacaoAlcancada(dto.getPontuacao());
        itemAtividadeRealizado.setTentativa(dto.getTentativa());
        itemAtividadeRealizado.setId(itemAtividadeRealizado.getId());

        return itemAtividadeRealizado;
    }

}
