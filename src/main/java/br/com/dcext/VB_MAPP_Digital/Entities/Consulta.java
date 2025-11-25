package br.com.dcext.VB_MAPP_Digital.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_consulta;
    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
    private Date data_consulta;
    private String pontuação_total;
    @OneToOne(mappedBy = "consulta", cascade = CascadeType.ALL)
    private Relatorio relatorio;
    @OneToOne(mappedBy = "consulta", cascade = CascadeType.ALL)
    private List<Atividade> atividade;
}
