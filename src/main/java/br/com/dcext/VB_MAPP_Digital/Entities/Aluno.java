package br.com.dcext.VB_MAPP_Digital.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int alunoId;
    private String nome;
    private String matricula;
    private String email;
    private String telefone;
    private String senha;
    private int periodo;
    @ManyToMany
    private List<Paciente> pacientes = new ArrayList<>();
}
