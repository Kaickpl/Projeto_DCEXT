package Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
    private Aluno id_aluno;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_paciente")
    private Paciente id_paciente;
    private Date data_consulta;
    private String pontuação_total;
}
