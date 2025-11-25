//package br.com.dcext.VB_MAPP_Digital.Entities;
//
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class AtividadeRealizada {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private int id;
//
//    @ManyToOne
//    private Atividade atividade;
//
//    @ManyToOne
//    @JoinColumn(name = "consulta_id")
//    private Consulta consulta;
//
//    private Integer pontuacao;
//    private LocalDateTime dataExecucao;
//}
