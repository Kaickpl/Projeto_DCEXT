package br.com.dcext.VB_MAPP_Digital.Services.impl;
import br.com.dcext.VB_MAPP_Digital.Entities.ItemAtividade;
import br.com.dcext.VB_MAPP_Digital.Repositories.ItemAtividadeRepository;
import br.com.dcext.VB_MAPP_Digital.Services.ItemAtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemAtividadeServiceImpl implements ItemAtividadeService {

    @Autowired
    private ItemAtividadeRepository itemAtividadeRepository;

    @Override
    public ItemAtividade buscarItemAtividadePorId(Integer id){
        return itemAtividadeRepository.findById(id).orElse(null);
    }

}
