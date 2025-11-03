package br.com.dcext.VB_MAPP_Digital.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idEndereco;
    private String cidade;
    private String estado;
    private String cep;
    private String rua;
    private String complemento;
    private String numero;
    private String bairro;
    @OneToOne(mappedBy = "endereco")
    private Paciente paciente;
}
