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
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String tipo;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private CategoriasATV categoria;
    private String reforcador;
    private String status;
    private String tentativa;
    private String descricao;
    private String pontuacaoMax;
}
