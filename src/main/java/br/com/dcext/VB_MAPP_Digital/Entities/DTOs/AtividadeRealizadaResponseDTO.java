package br.com.dcext.VB_MAPP_Digital.Entities.DTOs;

import br.com.dcext.VB_MAPP_Digital.Entities.Enums.PontuacaoVbMapp;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AtividadeRealizadaResponseDTO {
    private String paciente;

    private Integer idAtividadeRealizada;
    private Integer consultaId;
    private Integer itemAtividadeId;

    private String itemAtividadeTitulo;
    private PontuacaoVbMapp pontuacaoStatus;
    private double pontuacaoValor;
    private Integer tentativas;
}
