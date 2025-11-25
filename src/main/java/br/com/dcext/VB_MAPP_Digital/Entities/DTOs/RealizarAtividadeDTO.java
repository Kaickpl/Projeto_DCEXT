package br.com.dcext.VB_MAPP_Digital.Entities.DTOs;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RealizarAtividadeDTO {
    private int atividadeId;
    private Integer pontuacao;

    public RealizarAtividadeDTO(int atividadeId, Integer pontuacao) {
        this.atividadeId = atividadeId;
        this.pontuacao = pontuacao;
    }
}
