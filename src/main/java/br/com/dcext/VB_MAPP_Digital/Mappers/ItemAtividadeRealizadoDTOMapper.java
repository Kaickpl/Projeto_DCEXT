package br.com.dcext.VB_MAPP_Digital.Mappers;

import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.ItemAtividadeRealizadoDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.ItemAtividadeRealizado;

public class ItemAtividadeRealizadoDTOMapper {
    public static ItemAtividadeRealizadoDTO paraDTO(ItemAtividadeRealizado dto) {
        return new ItemAtividadeRealizadoDTO(
                dto.getId(),
                ItemAtividadeDTOMapper.paraDTO(dto.getItem()),
                dto.getTentativa(),
                dto.getPontuacaoAlcancada()
        );
    }
}
