package br.com.dcext.VB_MAPP_Digital.Mappers;

import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.ItemAtividadeDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.ItemAtividade;

public class ItemAtividadeDTOMapper {
    public static ItemAtividadeDTO paraDTO(ItemAtividade itemAtividade) {
        return new ItemAtividadeDTO(
                itemAtividade.getId(),
                itemAtividade.getTitulo(),
                itemAtividade.getTipo(),
                itemAtividade.getDescricao()
        );
    }
}
