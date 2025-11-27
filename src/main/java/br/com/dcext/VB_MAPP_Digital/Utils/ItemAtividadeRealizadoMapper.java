package br.com.dcext.VB_MAPP_Digital.Utils;

import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.AtividadeRealizadaResponseDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.ItemAtividadeRealizado;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ItemAtividadeRealizadoMapper {
    public static AtividadeRealizadaResponseDTO toReponseDTO(ItemAtividadeRealizado itemAtividade){
        if(itemAtividade == null){
            return null;
        }

        AtividadeRealizadaResponseDTO responseDTO = new AtividadeRealizadaResponseDTO();
        responseDTO.setItemAtividadeId(itemAtividade.getId());
        responseDTO.setItemAtividadeTitulo(itemAtividade.getItem().getTitulo());
        responseDTO.setConsultaId(itemAtividade.getConsulta().getConsultaId());
        responseDTO.setIdAtividadeRealizada(itemAtividade.getId());

        responseDTO.setPaciente(itemAtividade.getConsulta().getPaciente().getNomePaciente());

        responseDTO.setPontuacaoStatus(itemAtividade.getPontuacaoAlcancada());
        responseDTO.setPontuacaoValor(itemAtividade.getPontuacaoAlcancada().getValor());
        responseDTO.setTentativas(itemAtividade.getTentativa());

        return  responseDTO;
    }
}
