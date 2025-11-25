package br.com.dcext.VB_MAPP_Digital.Entities.DTOs;

import br.com.dcext.VB_MAPP_Digital.Entities.Endereco;
import br.com.dcext.VB_MAPP_Digital.Entities.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PacienteDTOs {
    private int idPaciente;
    private String nome;
    private String responsavel;
    private String numeroResponsavel;
    private String dataNascimento;
    private String genero;
    private String observacoes;
    private Endereco endereco;
    public PacienteDTOs(Paciente paciente) {
        this.idPaciente = paciente.getPacienteId();
        this.nome = paciente.getNome();
        this.responsavel = paciente.getResponsavel();
        this.numeroResponsavel = paciente.getNumeroResponsavel();
        this.dataNascimento = paciente.getDataNascimento();
        this.genero = paciente.getGenero();
        this.observacoes = paciente.getObservacoes();
        this.endereco = paciente.getEndereco();

    }
}
