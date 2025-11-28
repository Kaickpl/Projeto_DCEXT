package br.com.dcext.VB_MAPP_Digital.Services.impl;
import br.com.dcext.VB_MAPP_Digital.Entities.Consulta;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.AtividadeRealizadaResponseDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.DTOs.RealizarAtividadeDTO;
import br.com.dcext.VB_MAPP_Digital.Entities.ItemAtividade;
import br.com.dcext.VB_MAPP_Digital.Entities.ItemAtividadeRealizado;
import br.com.dcext.VB_MAPP_Digital.Repositories.ItemAtividadeRealizadoRepository;
import br.com.dcext.VB_MAPP_Digital.Repositories.ItemAtividadeRepository;
import br.com.dcext.VB_MAPP_Digital.Services.ConsultaService;
import br.com.dcext.VB_MAPP_Digital.Services.ItemAtividadeRealizadoService;
import br.com.dcext.VB_MAPP_Digital.Mappers.ItemAtividadeRealizadoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemAtividadeRealizadoServiceImpl implements ItemAtividadeRealizadoService {

    @Autowired
    private ItemAtividadeRealizadoRepository itemAtividadeRealizadoRepository;

    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private ItemAtividadeRepository itemAtividadeRepository;

    @Autowired
    private ItemAtividadeRealizadoMapper itemAtividadeRealizadoMapper;

    @Override
    public ItemAtividadeRealizado salvarAtividadeRealizada(RealizarAtividadeDTO itemAtividadeRealizado){
        ItemAtividadeRealizado entidade = itemAtividadeRealizadoMapper.toEntity(itemAtividadeRealizado);

        if(entidade.getConsulta() != null && entidade.getConsulta().getPaciente() != null){
            entidade.getConsulta().getPaciente().getNomePaciente();
        }
        return itemAtividadeRealizadoRepository.save(entidade);
    }

    @Override
    public ItemAtividadeRealizado editarAtividadeRealizada(Integer idAtividadeAntiga, RealizarAtividadeDTO itemAtividadeRealizado){
        ItemAtividadeRealizado atividadeOriginal = itemAtividadeRealizadoRepository.getById(idAtividadeAntiga);

        if(atividadeOriginal == null){
            return null;
        } else {
            atividadeOriginal.setPontuacaoAlcancada(itemAtividadeRealizado.getPontuacao());
            atividadeOriginal.setTentativa(itemAtividadeRealizado.getTentativa());
            return itemAtividadeRealizadoRepository.save(atividadeOriginal);
        }

    }

    @Override
    public void apagarAtividadeRealizada(Integer idAtividade){
        ItemAtividadeRealizado atividadeADeletar = itemAtividadeRealizadoRepository.findById(idAtividade).orElse(null);
        itemAtividadeRealizadoRepository.delete(atividadeADeletar);
    }

    @Override
    public AtividadeRealizadaResponseDTO buscarAtividadeRealizada(Integer idAtividade){
        ItemAtividadeRealizado atividadeRealizada = itemAtividadeRealizadoRepository.findById(idAtividade).orElse(null);
        AtividadeRealizadaResponseDTO responseDTO = itemAtividadeRealizadoMapper.toReponseDTO(atividadeRealizada);
        return responseDTO;
    }

}
