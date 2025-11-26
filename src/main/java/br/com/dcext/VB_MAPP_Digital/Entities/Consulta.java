package br.com.dcext.VB_MAPP_Digital.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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
    private int consultaId;
    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
    private Date dataConsulta;
    private Double pontuacaoTotal;
    private Double pontuacaoParcial;
    @OneToOne(mappedBy = "consulta", cascade = CascadeType.ALL)
    private Relatorio relatorio;
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL)
    private List<ItemAtividadeRealizado> atividades = new ArrayList<>();

    public void adicionarAtividade(ItemAtividadeRealizado realizada) {
        realizada.setConsulta(this);
        this.atividades.add(realizada);
        recalcularPontuacao();

    }

    private void recalcularPontuacao() {
        double total = atividades.stream().mapToDouble(a -> a.getPontuacaoAlcancada().getValor()).sum();

        this.pontuacaoParcial = total;

        if (!atividades.isEmpty()) {
            this.pontuacaoTotal = total / atividades.size();
        }else {
            this.pontuacaoTotal = 0.0;
        }
    }
}
