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
    private int id;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_aluno")
//    private Aluno id_aluno;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_paciente")
//    private Paciente id_paciente;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_consulta")
    private Consulta consulta;
    private String analise_aluno;
    private String resultado;
}
