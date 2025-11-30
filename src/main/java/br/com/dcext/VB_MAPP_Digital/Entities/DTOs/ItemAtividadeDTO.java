package br.com.dcext.VB_MAPP_Digital.Entities.DTOs;

import br.com.dcext.VB_MAPP_Digital.Entities.Enums.TipoATV;

public record ItemAtividadeDTO(int id, String titulo, TipoATV tipo, String descricao) {
}
