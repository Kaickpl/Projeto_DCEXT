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
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int pacienteId;
    private String nomePaciente;
    private String responsavel;
    private String numeroResponsavel;
    private String dataNascimento;
    private String genero;
    private String observacoes;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Endereco")
    private Endereco endereco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

}
