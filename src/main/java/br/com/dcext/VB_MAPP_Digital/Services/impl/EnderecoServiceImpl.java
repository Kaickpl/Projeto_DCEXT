package br.com.dcext.VB_MAPP_Digital.Services.impl;
import br.com.dcext.VB_MAPP_Digital.Entities.Endereco;
import br.com.dcext.VB_MAPP_Digital.Repositories.EnderecoRepository;
import br.com.dcext.VB_MAPP_Digital.Services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco buscarEnderecoPorId(Integer idEndereco){
        return enderecoRepository.findById(idEndereco).get();
    }


}
