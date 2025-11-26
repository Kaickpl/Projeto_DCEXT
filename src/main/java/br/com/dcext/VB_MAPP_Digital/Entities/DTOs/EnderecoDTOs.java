package br.com.dcext.VB_MAPP_Digital.Entities.DTOs;

import br.com.dcext.VB_MAPP_Digital.Entities.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTOs {
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    public EnderecoDTOs(Endereco endereco) {
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
    }
}
