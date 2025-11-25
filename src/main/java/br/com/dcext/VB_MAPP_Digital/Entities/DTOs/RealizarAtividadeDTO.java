package br.com.dcext.VB_MAPP_Digital.Entities.DTOs;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RealizarAtividadeDTO {
    private Integer consultaId;
    private Integer atividadeId;
    private Integer pontuacao;
    private Integer tentativa;

    public RealizarAtividadeDTO(Integer atividadeId, Integer pontuacao, Integer tentativa, Integer consultaId) {
        this.atividadeId = atividadeId;
        this.pontuacao = pontuacao;
        this.tentativa = tentativa;
        this.consultaId = consultaId;
    }
}
