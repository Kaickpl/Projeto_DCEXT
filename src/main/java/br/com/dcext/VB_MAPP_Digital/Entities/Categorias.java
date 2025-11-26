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
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String nome;

    private String descricao;

    private String reforcador;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<ItemAtividade> itens;
}
