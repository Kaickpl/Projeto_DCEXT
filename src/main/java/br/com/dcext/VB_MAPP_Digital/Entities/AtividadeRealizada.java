package br.com.dcext.VB_MAPP_Digital.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtividadeRealizada {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne
    private Atividade atividade;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Paciente paciente;

    private Float pontuacaoParcial;
    private String reforcador;
    private String status;
    private String tentativa;
    private LocalDateTime dataExecucao;
}
