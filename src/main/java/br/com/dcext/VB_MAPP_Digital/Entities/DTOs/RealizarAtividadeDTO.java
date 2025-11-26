package br.com.dcext.VB_MAPP_Digital.Entities.DTOs;


import br.com.dcext.VB_MAPP_Digital.Entities.Enums.PontuacaoVbMapp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RealizarAtividadeDTO {
    private Integer consultaId;
    private Integer atividadeId;
    private PontuacaoVbMapp pontuacao;
    private Integer tentativa;

    public RealizarAtividadeDTO(Integer atividadeId, PontuacaoVbMapp pontuacao, Integer tentativa, Integer consultaId) {
        this.atividadeId = atividadeId;
        this.pontuacao = pontuacao;
        this.tentativa = tentativa;
        this.consultaId = consultaId;
    }
}
