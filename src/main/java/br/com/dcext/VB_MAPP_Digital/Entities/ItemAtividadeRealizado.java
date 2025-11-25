package br.com.dcext.VB_MAPP_Digital.Entities;


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
public class ItemAtividadeRealizado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne
    private Consulta consulta;

    @ManyToOne
    private ItemAtividade item;

    private Integer tentativa;

    private float pontuacaoObtida;
}
