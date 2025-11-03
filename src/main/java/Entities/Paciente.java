package Entities;

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
    private int id;
    private String nome;
    private String responsavel;
    private String numeroResponsavel;
    private String dataNascimento;
    private String genero;
    private String observacoes;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEndereco")
    private Endereco Endereco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_aluno")
    private Aluno Aluno;
}
