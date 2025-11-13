package br.com.dcext.VB_MAPP_Digital.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriasATV {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idCategoria;
    private String imitacaoMotora;
    private String ecoico;
    private String ouvinte;
    private String brincarIndependente;
    private String comportamentoVocalEspontaneo;
    private String VPS_MTS;
    private String tato;
    private String brincadeiraSocial;
    private String mando;
    private float pontuacaoTotal;
    @OneToMany(mappedBy = "categoria",cascade = CascadeType.ALL)
    private List<Atividade> atividades;
}
