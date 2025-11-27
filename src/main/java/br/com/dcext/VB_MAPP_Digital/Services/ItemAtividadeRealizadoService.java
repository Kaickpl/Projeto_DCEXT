package br.com.dcext.VB_MAPP_Digital.Services;

import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.AtividadeRealizadaResponseDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.RealizarAtividadeDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.ItemAtividadeRealizado;

public interface ItemAtividadeRealizadoService {
    public ItemAtividadeRealizado salvarAtividadeRealizada(RealizarAtividadeDTO itemAtividadeRealizado);

    public ItemAtividadeRealizado editarAtividadeRealizada(Integer idAtividadeAntiga, RealizarAtividadeDTO itemAtividadeRealizado);

    public void apagarAtividadeRealizada(Integer idAtividade);

    public AtividadeRealizadaResponseDTO buscarAtividadeRealizada(Integer idAtividade);
}
