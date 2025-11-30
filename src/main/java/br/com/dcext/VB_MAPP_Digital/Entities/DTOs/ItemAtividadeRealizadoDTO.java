package br.com.dcext.VB_MAPP_Digital.Entities.DTOs;

import br.com.dcext.VB_MAPP_Digital.Entities.Enums.PontuacaoVbMapp;
import br.com.dcext.VB_MAPP_Digital.Entities.ItemAtividade;

public record ItemAtividadeRealizadoDTO(int id,
                                        ItemAtividadeDTO item,
                                        Integer tentativa,
                                        PontuacaoVbMapp pontuacaoAlcancada) {
}
