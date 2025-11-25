package br.com.dcext.VB_MAPP_Digital.Entities;


import br.com.dcext.VB_MAPP_Digital.Entities.Enums.TipoATV;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemAtividade {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String titulo;

    @Enumerated(EnumType.STRING)
    private TipoATV tipo;

    private String reforcador;

    private String descricao;


    private float pontuacaoMax;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categorias categoria;
}
