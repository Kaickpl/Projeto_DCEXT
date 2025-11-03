package br.com.dcext.VB_MAPP_Digital.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Relatorio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_relatorio;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_aluno")
    private Aluno id_aluno;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_paciente")
    private Paciente id_paciente;
    private String analise_aluno;
    private String resultado;
}
